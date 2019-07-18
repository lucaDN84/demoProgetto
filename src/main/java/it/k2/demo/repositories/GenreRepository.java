package it.k2.demo.repositories;

import it.k2.demo.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>
{
    Genre findByDescription(String description);
    Genre findById_Genre(Integer id_genre);
    List<Genre> findAll();
}
