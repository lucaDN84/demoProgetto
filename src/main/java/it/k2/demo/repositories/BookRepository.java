package it.k2.demo.repositories;

import it.k2.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Book, Integer>
{
    List<Book> findAllById_Author(Integer id_author);
    List<Book> findAllById_Genre(Integer id_genre);
    List<Book> findAllById_Publisher(Integer id_publisher);
    Book findByTitle (String title);
    List<Book> findById_Book(Integer id);
    List<Book> findAllBooks();

    boolean existsById(Integer id_book);
    boolean existsById_Author(Integer id_author);
    boolean existsById_Genre(Integer id_genre);
    boolean existsById_Publisher(Integer id_publisher);
    boolean existsByTitle(String title);

}
