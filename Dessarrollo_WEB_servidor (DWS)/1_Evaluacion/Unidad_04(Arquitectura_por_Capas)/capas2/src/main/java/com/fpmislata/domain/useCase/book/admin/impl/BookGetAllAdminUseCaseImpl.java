package com.fpmislata.domain.useCase.book.admin.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.useCase.book.admin.BookGetAllAdminUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookGetAllAdminUseCaseImpl implements BookGetAllAdminUseCase {
    private final BookService bookService;
    @Override
    public List<Book> getAll(int page, int size) {
        return bookService.getAll(page, size);
    }
}
