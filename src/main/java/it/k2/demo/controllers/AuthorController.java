package it.k2.demo.controllers;

import it.k2.demo.services.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class AuthorController {

    @Autowired
    Librarian librarian ;

    @RequestMapping(value="/authors")
    public String elencoAutori(Model model) {
        model.addAttribute("authors",librarian.getAuthorsInDatabaseToString());
        return "authorList";
    }




}
