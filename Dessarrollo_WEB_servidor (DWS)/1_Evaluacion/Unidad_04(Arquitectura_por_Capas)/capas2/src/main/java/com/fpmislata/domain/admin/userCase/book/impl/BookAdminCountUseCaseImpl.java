package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.admin.userCase.book.BookAdminCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminCountUseCaseImpl implements BookAdminCountUseCase {

    private final BookAdminService bookAdminService;

    @Override
    public int count() {
        return bookAdminService.count();
    }
}
