package it.k2.demo.controllers;

import it.k2.demo.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



    @Controller
    public class ServiceController
    {
        @Autowired
        LibrarianService librarian ;

        @RequestMapping(value="/books")
        public String elencoLibri(Model model) {
            model.addAttribute("books",librarian.getBookInDatabaseToString());
            return "bookList";
        }

        @RequestMapping(value="/authors")
        public String elencoAutori(Model model) {
            model.addAttribute("authors",librarian.getAuthorInDatabaseToString());
            return "authorList";
        }


        @RequestMapping(value="/authorsBooks")
        public String elencoLibriAutori(Model model) {
            model.addAttribute("authors",librarian.getAuthorsAndBooksToString());
            return "authorList";
        }




    }





