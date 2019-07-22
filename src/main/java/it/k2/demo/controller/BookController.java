package it.k2.demo.controller;

import it.k2.demo.services.Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



    @Controller
    public class BookController
    {
        @Autowired
        Logic logic ;

        @RequestMapping(value="/books")
        public String elencoLibri(Model model) {
            model.addAttribute("books",logic.getBooksInDatabaseToString());
            return "output";
        }


        @RequestMapping(value="/authors")
        public String elencoAutori(Model model) {
            model.addAttribute("authors",logic.getAuthorsInDatabaseToString());
            return "output";
        }





    }





