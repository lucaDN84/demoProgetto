package it.k2.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String title;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {  }

    public Author(Integer id, @NotNull String title, Set<Book> books)
    {
        this.id = id;
        this.title = title;
        this.books = books;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Book> getBooks() {
        return books;
    }
}

