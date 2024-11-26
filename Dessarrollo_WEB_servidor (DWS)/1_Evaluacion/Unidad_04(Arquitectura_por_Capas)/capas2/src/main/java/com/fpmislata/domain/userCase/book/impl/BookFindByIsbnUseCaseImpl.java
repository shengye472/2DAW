package com.fpmislata.domain.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.userCase.book.BookFindByIsbnUseCase;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookFindByIsbnUseCaseImpl implements BookFindByIsbnUseCase {

    private final BookService bookAdminService;

    @Override
    public Book findByIsbn(String isbn) {
        return bookAdminService.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("book isbn " + isbn + " not found"));
    }
}
