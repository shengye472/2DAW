package com.fpmislata.domain.service.impl;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.repository.BookRepository;
import com.fpmislata.domain.service.BookService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class BookServiceImpl implements BookService {

     private final BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

//    @Override
//    public Book findByIsbn(String isbn) {
//        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("Book not found"));
//    }

}
