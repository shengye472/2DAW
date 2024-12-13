package com.fpmislata.domain.useCase.book.common.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.useCase.book.common.BookGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookGetAllUseCaseImpl implements BookGetAllUseCase {
    private final BookService bookService;
    @Override
    public List<Book> getAll(int i, int pageSize) {
        return bookService.getAll(i,pageSize);
    }
}
