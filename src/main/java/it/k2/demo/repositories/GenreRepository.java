package it.k2.demo.repositories;

import it.k2.demo.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>
{

    List<Genre> findAll();

    boolean existsById(Integer id_genre);

    Genre findByDescription(String description);

    boolean existsByDescription(String description);




}
