package it.k2.demo;
import it.k2.demo.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

//    @Autowired
//    BooksComponent bc;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

}

