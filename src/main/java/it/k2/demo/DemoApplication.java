package it.k2.demo;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.repositories.BookRepository;
import it.k2.demo.services.InsertBook;
import it.k2.demo.services.SaveMethod;
import it.k2.demo.services.SearchMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.dao.DataIntegrityViolationException;

@SpringBootApplication
public class DemoApplication implements ApplicationListener<ApplicationReadyEvent>
{

    @Autowired
    InsertBook insert;

    @Autowired
    SearchMethod searchMethod;

    Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

	    try
	    {
			insert.insertNewBook(        "Delitto e Castigo","Fedor Dostoevskij","Mondadori","Romanzo",1,9.50);
			log.info("Libro inserito");
		}
			catch (DataIntegrityViolationException e)
		{
			log.info("Errore salvataggio Libro");
	    }




	    List<Author> listaAutori = new ArrayList<>();

        Book book = searchMethod.getBookInDatabase("Delitto e Castigo");

        log.info(book.getTitle());

        listaAutori.addAll(searchMethod.getAuthorsByBook("Delitto e Castigo"));

        for(Author author :listaAutori) {
            log.info(author.getName());
        }








    }
}
