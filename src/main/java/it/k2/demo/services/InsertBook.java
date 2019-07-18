package it.k2.demo.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public interface InsertBook {

     void insertNewBook(String bookTitle, String authorName, String publisherName, String genreDescription, Integer quantity, Double price) throws DataIntegrityViolationException;
}
