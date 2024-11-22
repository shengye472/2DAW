package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.admin.userCase.book.BookAdminFindByIsbnUseCase;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminFindByIsbnUseCaseImpl implements BookAdminFindByIsbnUseCase {

    private final BookService bookAdminService;

    @Override
    public Book findByIsbn(String isbn) {
        return bookAdminService.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("book isbn " + isbn + " not found"));
    }
}
