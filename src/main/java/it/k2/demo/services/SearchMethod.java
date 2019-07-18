package it.k2.demo.services;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchMethod {


    List<Book> getBooksByAuthor(String authorName);

    List<Book> getBooksByGenre(String genre);

    List<Book> getBooksByPublisher(String publisher);

    public Book getBookInDatabase(String titleBook);

    List<Author> getAuthorsByBook(String titleBook);

}
