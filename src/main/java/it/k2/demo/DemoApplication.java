package it.k2.demo;

import it.k2.demo.models.Author;
import it.k2.demo.models.Book;
import it.k2.demo.models.Genre;
import it.k2.demo.models.Publisher;
import it.k2.demo.services.Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class DemoApplication implements ApplicationListener<ApplicationReadyEvent>
{

    @Autowired
    Logic logic;



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event)
    {


        Book book1 = new Book();
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


        book1.setAuthors(authorList);
        book1.setGenre(genre);
        book1.setPublisher(publisher);
        book1.setTitle("Delitto e Castigo");
	    book1.setQuantity(1);
	    book1.setPrice(10.00);

        book2.setAuthors(authorList);
        book2.setGenre(genre);
        book2.setPublisher(publisher);
        book2.setTitle("L'Idiota");
        book2.setQuantity(1);
        book2.setPrice(9.90);

        book3.setAuthors(authorList);
        book3.setGenre(genre);
        book3.setPublisher(publisher);
        book3.setTitle("Il Giocatore");
        book3.setQuantity(1);
        book3.setPrice(6.00);


        //inserimento dei libri:

        logic.insertNewBook(book1);


        logic.insertNewBook(book2);


        logic.insertNewBook(book3);


	  //  for(String lista : logic.getAuthorsInDatabaseToString()) {
	   //         log.info(lista);
      //  }


	  // List<Author> listaAutori = new ArrayList<>();



      //  listaAutori = logic.getAuthorsByBook("Il Giocatore");

      //  for(Author author2 : listaAutori) {
      //      log.info(author2.getName());
      //  }








    }
}
