package it.k2.demo.component;

import it.k2.demo.models.*;
import it.k2.demo.services.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

@Component
public class ComponentBook {

    @Autowired
    Librarian librarian;


    public void saveNewBook() {


        //List<Book> listaLibri = new ArrayList<>();


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


        //listaLibri.add(book1);
        //listaLibri.add(book2);
        //listaLibri.add(book3);

        //inserimento dei libri:

       librarian.insertNewBook(book1);


       librarian.insertNewBook(book2);


       librarian.insertNewBook(book3);
    }
}
