package it.k2.demo.controller;

import it.k2.demo.repositories.AuthorRepository;
import it.k2.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @RequestMapping("/welcome")
    @ResponseBody
    public String hello() {
        return "Ciao";
    }

    @RequestMapping("/books",method = RequestMethod.GET)
    @ResponseBody
    public String listaLibri() {

          for (int i = 0; i < bookRepository.findAll().size(); i++) {



             return bookRepository.findAll().get(i).getTitle();
          }


    }


}


