package it.k2.demo.repositories;

import it.k2.demo.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository  extends JpaRepository<Publisher, Integer>
{
    Publisher findByName(String name);
   // Publisher findById_Publisher(Integer id_publisher);
    List<Publisher> findAll();

    boolean existsByName(String name);
    boolean existsById(Integer id_publisher);
}
