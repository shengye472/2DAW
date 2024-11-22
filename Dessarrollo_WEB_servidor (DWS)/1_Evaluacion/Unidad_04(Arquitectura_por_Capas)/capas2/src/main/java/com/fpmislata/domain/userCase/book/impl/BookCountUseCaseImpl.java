package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.admin.userCase.book.BookAdminCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminCountUseCaseImpl implements BookAdminCountUseCase {

    private final BookService bookAdminService;

    @Override
    public int count() {
        return bookAdminService.count();
    }
}
