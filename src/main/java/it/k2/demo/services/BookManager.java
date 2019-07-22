package it.k2.demo.services;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import it.k2.demo.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class BookManager {

    @Autowired
    BookRepository bookRepository;


    public List<Author> getAuthorsByBook(String titleBook) {

        List<Author> authorList = new ArrayList<>();

        authorList.addAll(bookRepository.findByTitle(titleBook).getAuthors());

        return authorList;


    }
/* *****************************************************************************************/


    public List<String> getBookInDatabaseToString()
    {

        List<Book> books = getBookInDatabase();
        List<String> newBooksList = new ArrayList<>();

        for(int i = 0; i < books.size(); i++)
        {
            Book book = books.get(i);

            newBooksList.add(book.getTitle() + " " + books.get(i).getGenre().getDescription() + " " + books.get(i).getPublisher().getName() + "\n");

        }

        return newBooksList;
    }


    /* ******************************************************************************************/

    public List<Book> getBookInDatabase() {

        List<Book> listaLibri = new ArrayList<>();

        listaLibri = bookRepository.findAll();

        return listaLibri;
    }
/* *********************************************************************************************/








}
