package it.k2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;



@SpringBootApplication
public class DemoApplication
{

    @Autowired
    BooksComponent bc;

	public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class,args);
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.scan("it.k2.demo");
//        context.refresh();
//
//        BooksComponent bc = context.getBean(BooksComponent.class);
//
//        context.close();
    }

}
