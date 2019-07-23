package it.k2.demo.controller;

import it.k2.demo.services.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



    @Controller
    public class BookController
    {
        @Autowired
        Librarian librarian ;

        @RequestMapping(value="/books")
        public String elencoLibri(Model model) {
            model.addAttribute("books",librarian.getBookInDatabaseToString());
            return "bookList";
        }

    }





