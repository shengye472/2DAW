package com.fpmislata.exam.domain.usecase.impl;

import com.fpmislata.exam.common.annotation.DomainService;
import com.fpmislata.exam.domain.model.Book;
import com.fpmislata.exam.domain.service.BookService;
import com.fpmislata.exam.domain.usecase.BookFindAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class BookFindAllUseCaseImpl implements BookFindAllUseCase {

    private final BookService bookService;

    @Override
    public List<Book> findAll() {
        return bookService.findAll();
    }

}
