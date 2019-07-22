package it.k2.demo.repositories;

import it.k2.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>
{

    Author findByName(String name);
    //Author findById_Author(Integer id);
    List<Author> findAll();

    boolean existsById(Integer id);

    boolean existsByName(String name);

}
