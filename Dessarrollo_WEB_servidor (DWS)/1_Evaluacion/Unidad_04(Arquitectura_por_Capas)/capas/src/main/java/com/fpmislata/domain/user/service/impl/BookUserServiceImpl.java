package com.fpmislata.domain.user.service.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.user.entity.Book;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import com.fpmislata.domain.user.repository.BookUserRepository;
import com.fpmislata.domain.user.service.BookUserService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
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
