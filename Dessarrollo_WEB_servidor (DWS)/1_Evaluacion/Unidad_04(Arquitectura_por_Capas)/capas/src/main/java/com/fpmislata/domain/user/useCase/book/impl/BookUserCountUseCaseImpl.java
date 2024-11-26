package com.fpmislata.domain.user.useCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.user.service.BookUserService;
import com.fpmislata.domain.user.useCase.book.BookUserCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookUserCountUseCaseImpl implements BookUserCountUseCase {
    private final BookUserService bookUserService;

    @Override
    public int count() {
        return bookUserService.count();
    }
}
