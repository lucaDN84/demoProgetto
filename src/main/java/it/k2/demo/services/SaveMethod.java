package it.k2.demo.services;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public interface SaveMethod {

         void saveBook(Book book) throws DataIntegrityViolationException;

         void saveAuthor(Author author) throws DataIntegrityViolationException;

         void saveGenre(Genre genre) throws DataIntegrityViolationException;

         void savePublisher(Publisher publisher) throws DataIntegrityViolationException;


}