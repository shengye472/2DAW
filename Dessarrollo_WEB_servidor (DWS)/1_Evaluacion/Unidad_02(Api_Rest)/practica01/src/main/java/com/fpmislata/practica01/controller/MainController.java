package com.fpmislata.practica01.controller;

import com.fpmislata.practica01.domain.BookService;
import com.fpmislata.practica01.domain.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public void index(){
        System.out.println("Index option");
    }

    @GetMapping("/books")
    public void books(){
        System.out.println("Books option");
    }

    @GetMapping("/books/{id}")
    public void book(@PathVariable int id){
        System.out.println("Book option id:" + id);
    }
}
