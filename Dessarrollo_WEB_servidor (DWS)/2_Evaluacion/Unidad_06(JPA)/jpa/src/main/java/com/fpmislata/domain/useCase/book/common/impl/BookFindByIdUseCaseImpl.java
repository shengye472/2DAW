package com.fpmislata.domain.useCase.book.common.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.common.exception.ResourceNotFoundException;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.useCase.book.common.BookFindByIsbnUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookFindByIdUseCaseImpl implements BookFindByIsbnUseCase {
    private final BookService bookService;

    @Override
    public Book findByIsbn(String isbn) {
        return bookService
                .findByIsbn(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book with isbn " + isbn + " not found"));
    }
}
