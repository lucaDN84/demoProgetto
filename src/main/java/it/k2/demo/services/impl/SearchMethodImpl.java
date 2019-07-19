package it.k2.demo.services.impl;
import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.repositories.AuthorRepository;
import it.k2.demo.repositories.BookRepository;
import it.k2.demo.repositories.GenreRepository;
import it.k2.demo.repositories.PublisherRepository;
import it.k2.demo.services.SearchMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class SearchMethodImpl implements SearchMethod {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    GenreRepository genreRepository;


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
    public List<Author> getAuthorsByBook(String titleBook) {

        List<Author> authorList = new ArrayList<>();

        authorList.addAll(bookRepository.findByTitle(titleBook).getAuthors());

        return authorList;
    }


}
