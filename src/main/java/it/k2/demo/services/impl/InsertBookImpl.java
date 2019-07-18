package it.k2.demo.services.impl;

import it.k2.demo.models.*;
import it.k2.demo.repositories.AuthorRepository;
import it.k2.demo.repositories.BookRepository;
import it.k2.demo.repositories.GenreRepository;
import it.k2.demo.repositories.PublisherRepository;
import it.k2.demo.services.InsertBook;
import it.k2.demo.services.SaveMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.HashSet;
import java.util.Set;

public class InsertBookImpl implements InsertBook {


    @Autowired
    SaveMethod save;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    BookRepository bookRepository;



    @Override
    public void insertNewBook(String bookTitle, String authorName, String publisherName, String genreDescription, Integer quantity, Double price) throws DataIntegrityViolationException{


        Logger log = LoggerFactory.getLogger(InsertBookImpl.class);


        //inserisco gli attributi del libro e degli altri entity
        //li salvo come attributi oggetti,

        //verifico se esistono nel database

        //li  salvo nel database


        Book book = new Book();

        Author author = new Author();

        Publisher publisher = new Publisher();

        Genre genre = new Genre();

        Set<Author> authorList = new HashSet<>();


        book.setQuantity(quantity);



        publisher.setName(publisherName);
        genre.setDescription(genreDescription);



        try
        {
            save.saveGenre(genre);
        }
        catch (DataIntegrityViolationException e)
        {
            log.info("Errore salvataggio GENERE");

        }


        try
        {
            save.savePublisher(publisher);
        }
        catch (DataIntegrityViolationException e1)
        {
            log.info("Errore salvataggio EDITORE");

        }


        book.setGenre(genreRepository.findByName(genreDescription));
        book.setPublisher(publisherRepository.findByName(publisherName));

        book.setTitle(bookTitle);
        book.setPrice(price);
        book.setQuantity(quantity);
        author.setName(authorName);

        try
        {
            save.saveAuthor(author);
        }
        catch (DataIntegrityViolationException e3)
        {
            log.info("Errore salvataggio Autore");

        }
        authorList.add(authorRepository.findByName(authorName));
        book.setAuthors(authorList);

        try
        {
            save.saveBook(book);
        }
        catch (DataIntegrityViolationException e2)
        {
            log.info("Errore salvataggio LIBRO");
        }















    }
}
