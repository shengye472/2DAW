package com.fpmislata.domain.useCase.book.common.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.useCase.book.common.BookCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookCountUseCaseImpl implements BookCountUseCase {

    private final BookService bookService;

    @Override
    public int count() {
        return bookService.count();
    }
}
