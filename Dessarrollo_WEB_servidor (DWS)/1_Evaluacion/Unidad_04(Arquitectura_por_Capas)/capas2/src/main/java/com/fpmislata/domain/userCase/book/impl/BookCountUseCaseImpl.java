package com.fpmislata.domain.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.userCase.book.BookCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookCountUseCaseImpl implements BookCountUseCase {

    private final BookService bookAdminService;

    @Override
    public int count() {
        return bookAdminService.count();
    }
}
