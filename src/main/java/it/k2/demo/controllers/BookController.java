package it.k2.demo.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.k2.demo.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



    @Controller
    public class BookController
    {
        @Autowired
        LibrarianService librarian ;

//        @RequestMapping(value="/books")
        @GetMapping
        public String elencoLibri(Model model) {
            model.addAttribute("books",librarian.getBook());
            return "bookList";
        }

    }





