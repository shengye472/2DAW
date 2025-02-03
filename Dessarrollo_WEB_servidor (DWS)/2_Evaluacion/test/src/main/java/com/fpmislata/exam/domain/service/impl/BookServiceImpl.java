package com.fpmislata.exam.domain.service.impl;

import com.fpmislata.exam.domain.model.Book;
import com.fpmislata.exam.domain.repository.BookRepository;
import com.fpmislata.exam.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
