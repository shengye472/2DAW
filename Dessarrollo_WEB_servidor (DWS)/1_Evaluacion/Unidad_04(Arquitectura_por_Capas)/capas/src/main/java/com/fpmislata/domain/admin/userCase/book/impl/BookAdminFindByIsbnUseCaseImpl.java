package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.admin.userCase.book.BookAdminFindByIsbnUseCase;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminFindByIsbnUseCaseImpl implements BookAdminFindByIsbnUseCase {

    private final BookAdminService bookAdminService;

    @Override
    public Book findByIsbn(String isbn) {
        return bookAdminService.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("book isbn " + isbn + " not found"));
    }
}
