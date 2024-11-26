package com.fpmislata.domain.user.useCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.user.entity.Book;
import com.fpmislata.domain.user.service.BookUserService;
import com.fpmislata.domain.user.useCase.book.BookUserGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookUserGetAllUseCaseImpl implements BookUserGetAllUseCase {
    private final BookUserService bookUserService;
    @Override
    public List<Book> getAll(int i, int pageSize) {
        return bookUserService.getAll(i,pageSize);
    }
}
