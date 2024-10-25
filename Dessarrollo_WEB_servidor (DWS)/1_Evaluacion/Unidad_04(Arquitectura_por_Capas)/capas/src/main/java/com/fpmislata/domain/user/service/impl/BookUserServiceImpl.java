package com.fpmislata.domain.user.service.impl;

import com.fpmislata.domain.user.entity.Book;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import com.fpmislata.persistence.user.repository.BookUserRepository;
import com.fpmislata.domain.user.service.BookUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookUserServiceImpl implements BookUserService {
    private final BookUserRepository bookRepository;

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
