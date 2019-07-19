package it.k2.demo.controller;

import it.k2.demo.models.Book;
import it.k2.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @Controller
    public class DemoController
    {
        @RequestMapping(value="/home")


        public String getIndex()
        {
            return "index";
        }
    }












    @RequestMapping("/welcome")
    @ResponseBody
    public String hello() {
        return "Ciao";
    }

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView listaLibri() {



        List<Book> list = bookRepository.findAll();
        List<String> listaTitoli = new ArrayList<>();
        for(Book book : list) {
            listaTitoli.add(book.getTitle());
        }

        //return back to index.jsp
        ModelAndView model = new ModelAndView();
        model.addObject("lists", listaTitoli);

        return model;


    }


}


