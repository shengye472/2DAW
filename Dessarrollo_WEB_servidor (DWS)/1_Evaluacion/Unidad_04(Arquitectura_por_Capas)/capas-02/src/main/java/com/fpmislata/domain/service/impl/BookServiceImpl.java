package com.fpmislata.domain.service.impl;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import com.fpmislata.persistence.repository.BookRepository;
import com.fpmislata.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll(int page, int size) {
        return bookRepository.getAll(page, size);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book isbn " + isbn + " not found"));
    }

    @Override
    public int count() {
        return bookRepository.count();
    }
}
