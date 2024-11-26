package com.fpmislata.domain.user.useCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.user.entity.Book;
import com.fpmislata.domain.user.service.BookUserService;
import com.fpmislata.domain.user.useCase.book.BookUseFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookUserFindByIdUseCaseImpl implements BookUseFindByIdUseCase {
    private final BookUserService bookUserService;

    @Override
    public Book findByIsbn(String isbn) {
        return bookUserService.findByIsbn(isbn);
    }
}
