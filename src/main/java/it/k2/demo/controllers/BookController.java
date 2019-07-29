package it.k2.demo.controllers;

import it.k2.demo.models.BookDto;
import it.k2.demo.service.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    Connection connection;

    @GetMapping
    public String elencoLibri(Model model) {
        RestTemplate rest = new RestTemplate();
        List<BookDto> books = new ArrayList<>();
        try {

            ResponseEntity<List<BookDto>> booksResponse = rest.exchange(connection.getUrl(), HttpMethod.GET, null, new ParameterizedTypeReference<List<BookDto>>() {
            });
            if (booksResponse != null && booksResponse.hasBody()) {
                books = booksResponse.getBody();

            }

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("books", books);

        return "bookList";
    }

}





