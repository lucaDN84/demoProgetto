package it.k2.demo;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import it.k2.demo.services.Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import org.springframework.dao.DataIntegrityViolationException;

@SpringBootApplication
public class DemoApplication implements ApplicationListener<ApplicationReadyEvent>
{

    @Autowired
    InsertBook insert;

    @Autowired
    SearchMethod searchMethod;

    @Autowired
    Logic logic;

    Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {


	    Book book = new Book();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Author author = new Author();

	    author.setName("Fedor Dostoevskij");

        Set<Author> authorList = new HashSet<>();

        authorList.add(author);

        genre.setDescription("Romanzo");
        publisher.setName("Mondadori");


        book.setAuthors(authorList);
        book.setGenre(genre);
        book.setPublisher(publisher);
        book.setTitle("Delitto e Castigo");
	    book.setQuantity(1);
	    book.setPrice(10.00);



	    try
        {
            logic.insertNewBook(book);
            log.info("Libro inserito");
        }
        catch (DataIntegrityViolationException e)
        {
            log.info("Errore salvataggio Libro");
        }

	    List<Author> listaAutori = new ArrayList<>();

        Book book2 = searchMethod.getBookInDatabase("Delitto e Castigo");

        log.info(book2.getTitle());

        listaAutori.addAll(searchMethod.getAuthorsByBook("Delitto e Castigo"));

        for(Author author2 :listaAutori) {
            log.info(author2.getName());
        }








    }
}
