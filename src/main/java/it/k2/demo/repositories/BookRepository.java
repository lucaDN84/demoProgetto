package it.k2.demo.repositories;

import it.k2.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Book, Integer>
{

    Book findByTitle (String title);

    boolean existsById(Integer id_book);

    boolean existsByTitle(String title);



}
