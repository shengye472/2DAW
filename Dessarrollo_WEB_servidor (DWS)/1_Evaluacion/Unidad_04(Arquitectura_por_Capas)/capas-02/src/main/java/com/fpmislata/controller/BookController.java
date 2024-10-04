package com.fpmislata.controller;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/{isbn}")
    public Book findByIsbn(@PathVariable String isbn){
        return bookService.findByIsbn(isbn);
    }
}
