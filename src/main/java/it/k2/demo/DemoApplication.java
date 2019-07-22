package it.k2.demo;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import it.k2.demo.services.Librarian;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.HashSet;
import java.util.Set;
//import org.springframework.dao.DataIntegrityViolationException;

@SpringBootApplication
public class DemoApplication implements ApplicationListener<ApplicationReadyEvent>
{

    @Autowired
    Librarian librarian;

    Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event)
    {

	    Book book = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
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

        book2.setAuthors(authorList);
        book2.setGenre(genre);
        book2.setPublisher(publisher);
        book2.setTitle("Il Signore Degli Anelli");
        book2.setQuantity(5);
        book2.setPrice(50.00);

        book3.setAuthors(authorList);
        book3.setGenre(genre);
        book3.setPublisher(publisher);
        book3.setTitle("Harry Potter");
        book3.setQuantity(7);
        book3.setPrice(60.00);




        try
        {
            librarian.insertNewBook(book);
            librarian.insertNewBook(book2);
            librarian.insertNewBook(book3);
            log.info("Libro inserito");
        }
        catch (DataIntegrityViolationException e)
        {
            log.info("Errore salvataggio Libro");
        }







    }
}
