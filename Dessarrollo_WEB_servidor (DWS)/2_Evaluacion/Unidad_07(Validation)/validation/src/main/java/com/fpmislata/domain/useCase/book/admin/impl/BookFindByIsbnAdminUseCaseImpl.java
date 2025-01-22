package com.fpmislata.domain.useCase.book.admin.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.common.exception.ResourceNotFoundException;
import com.fpmislata.domain.useCase.book.admin.BookFindByIsbnAdminUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookFindByIsbnAdminUseCaseImpl implements BookFindByIsbnAdminUseCase {

    private final BookService bookService;

    @Override
    public Book findByIsbn(String isbn) {
        return bookService.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("book isbn " + isbn + " not found"));
    }
}
