package it.k2.demo.services;

import it.k2.demo.models.Book;
import it.k2.demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;


    public List<Book> getBooksByPublisher(String publisher) {
        List<Book> bookList = new ArrayList<>();

        bookList.addAll(publisherRepository.findByName(publisher).getBooks());

        return bookList;
    }





}
