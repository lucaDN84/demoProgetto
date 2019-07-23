package it.k2.demo.services;

import it.k2.demo.models.Book;
import it.k2.demo.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<Book> getBooksByGenre(String genre) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(genreRepository.findByDescription(genre).getBooks());

        return bookList;
    }


}
