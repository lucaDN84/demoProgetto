package it.k2.demo.services.impl;
import java.util.Iterator;
import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import it.k2.demo.repositories.AuthorRepository;
import it.k2.demo.repositories.BookRepository;
import it.k2.demo.repositories.GenreRepository;
import it.k2.demo.repositories.PublisherRepository;
import it.k2.demo.services.Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class LogicImpl implements Logic {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;



    @Override
    public void insertNewBook(Book book) throws DataIntegrityViolationException {

        Logger log = LoggerFactory.getLogger(LogicImpl.class);


        Author author = new Author();

        Publisher publisher = new Publisher();

        Genre genre = new Genre();

        Set<Author> authorList = new HashSet<>();


        genre = book.getGenre();
        publisher = book.getPublisher();


        try {
            saveGenre(genre);
        } catch (DataIntegrityViolationException e) {
            log.info("Errore salvataggio GENERE");

        }


        try {
            savePublisher(publisher);
        } catch (DataIntegrityViolationException e1) {
            log.info("Errore salvataggio EDITORE");

        }


        book.setGenre(genreRepository.findByDescription(book.getGenre().getDescription()));
        book.setPublisher(publisherRepository.findByName(book.getPublisher().getName()));


        //prendo la lista degli autori dal libro:


        authorList.addAll(book.getAuthors());

        for (Author authorBook : authorList) {

            try {
                saveAuthor(authorBook);
            } catch (DataIntegrityViolationException e3) {
                log.info("Errore salvataggio Autore");

            }


        }

        for (Author author3 : book.getAuthors()) {
            for (Iterator<Author> iterator = authorRepository.findAll().iterator(); iterator.hasNext(); author = iterator.next()) {
                if (author3.getName().equals(author.getName())) {
                    authorList.add(author);
                }
                book.setAuthors(authorList);
            }
            try {
                saveBook(book);
            } catch (DataIntegrityViolationException e2) {
                log.info("Errore salvataggio LIBRO");
            }

        }
    }
    @Override
    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(authorRepository.findByName(authorName).getBooks());

        return bookList;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(genreRepository.findByDescription(genre).getBooks());

        return bookList;
    }

    @Override
    public List<Book> getBooksByPublisher(String publisher) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(publisherRepository.findByName(publisher).getBooks());

        return bookList;
    }

    @Override
    public Book getBookInDatabase(String titleBook) {
        Book book  = new Book();

        book = bookRepository.findByTitle(titleBook);

        return book;
    }

    @Override
    public void saveBook(Book book) throws DataIntegrityViolationException {
        String titleBook = book.getTitle();

        if(!bookRepository.existsByTitle(titleBook)) {

            bookRepository.save(book);

        }
    }

    @Override
    public void saveAuthor(Author author) throws DataIntegrityViolationException {

        String authorName = author.getName();

        if(!authorRepository.existsByName(authorName)) {
            authorRepository.save(author);
        }


    }

    @Override
    public void saveGenre(Genre genre) throws DataIntegrityViolationException {

        String genreDescription = genre.getDescription();

        if(!genreRepository.existsByDescription(genreDescription)) {
            genreRepository.save(genre);
        }
    }

    @Override
    public void savePublisher(Publisher publisher) throws DataIntegrityViolationException {

        String publisherName = publisher.getName();

        if(!publisherRepository.existsByName(publisherName)) {
            publisherRepository.save(publisher);

        }

    }

    @Override
    public List<Author> getAuthorsByBook(String titleBook) {

        List<Author> authorList = new ArrayList<>();

        authorList.addAll(bookRepository.findByTitle(titleBook).getAuthors());

        return authorList;


    }



}

