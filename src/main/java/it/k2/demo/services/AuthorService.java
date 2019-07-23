package it.k2.demo.services;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;



    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(authorRepository.findByName(authorName).getBooks());

        return bookList;
    }


 /* *****************************************************************************************/
    public List<Author> getAuthorInDataBase() {

        List<Author> listaAuthor = new ArrayList<>();

        listaAuthor = authorRepository.findAll();

        return listaAuthor;
 }


}
