package it.k2.demo.services;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import it.k2.demo.repositories.AuthorRepository;
import it.k2.demo.repositories.BookRepository;
import it.k2.demo.repositories.GenreRepository;
import it.k2.demo.repositories.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class Logic {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;




    public void insertNewBook(Book book) {

        Logger log = LoggerFactory.getLogger(Logic.class);


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

    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(authorRepository.findByName(authorName).getBooks());

        return bookList;
    }


    public List<Book> getBooksByGenre(String genre) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(genreRepository.findByDescription(genre).getBooks());

        return bookList;
    }


    public List<Book> getBooksByPublisher(String publisher) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(publisherRepository.findByName(publisher).getBooks());

        return bookList;
    }


    public List<Book> getBookInDatabase() {

        List<Book> listaLibri = new ArrayList<>();

        listaLibri = bookRepository.findAll();

        return listaLibri;
    }


    public void saveBook(Book book) throws DataIntegrityViolationException {
        String titleBook = book.getTitle();

        if(!bookRepository.existsByTitle(titleBook)) {

            bookRepository.save(book);

        }
    }


    public void saveAuthor(Author author) throws DataIntegrityViolationException {

        String authorName = author.getName();

        if(!authorRepository.existsByName(authorName)) {
            authorRepository.save(author);
        }


    }


    public void saveGenre(Genre genre) throws DataIntegrityViolationException {

        String genreDescription = genre.getDescription();

        if(!genreRepository.existsByDescription(genreDescription)) {
            genreRepository.save(genre);
        }
    }


    public void savePublisher(Publisher publisher) throws DataIntegrityViolationException {

        String publisherName = publisher.getName();

        if(!publisherRepository.existsByName(publisherName)) {
            publisherRepository.save(publisher);

        }

    }


    public List<Author> getAuthorsByBook(String titleBook) {

        List<Author> authorList = new ArrayList<>();

        authorList.addAll(bookRepository.findByTitle(titleBook).getAuthors());

        return authorList;


    }


    public List<String> getBooksInDatabaseToString() {
        List<Book> listaLibri = getBookInDatabase();

        List<String> listaLibriToString = new ArrayList<>();

        for(Book book : listaLibri) {
            listaLibriToString.add(book.getTitle());
        }
        return listaLibriToString;
    }


    public List<String> getAuthorsInDatabaseToString() {
        List<Author> listaAutori = authorRepository.findAll();

        List<String> listaAutoriToString = new ArrayList<>();

        for(Author author : listaAutori) {
            listaAutoriToString.add(author.getName());
        }
        return listaAutoriToString;
    }





}

