package it.k2.demo.services.impl;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import it.k2.demo.repositories.AuthorRepository;
import it.k2.demo.repositories.BookRepository;
import it.k2.demo.repositories.GenreRepository;
import it.k2.demo.repositories.PublisherRepository;
import it.k2.demo.services.SaveMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class SaveMethodImpl implements SaveMethod {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    PublisherRepository publisherRepository;



    @Override
    public void saveBook(Book book) {

        //vedo se esiste il libro dal suo titolo
        //se non esiste lo salvo

        String titleBook = book.getTitle();

        if(!bookRepository.existsByTitle(titleBook)) {

            bookRepository.save(book);

        }
    }

    @Override
    public void saveAuthor(Author author) {


        String authorName = author.getName();

        if(!authorRepository.existsByName(authorName)) {
            authorRepository.save(author);
        }
    }

    @Override
    public void saveGenre(Genre genre) {

        String genreDescription = genre.getDescription();

        if(!genreRepository.existsByDescription(genreDescription)) {
            genreRepository.save(genre);
        }

    }

    @Override
    public void savePublisher(Publisher publisher) {

        String publisherName = publisher.getName();

        if(!publisherRepository.existsByName(publisherName)) {
            publisherRepository.save(publisher);

        }

    }
}
