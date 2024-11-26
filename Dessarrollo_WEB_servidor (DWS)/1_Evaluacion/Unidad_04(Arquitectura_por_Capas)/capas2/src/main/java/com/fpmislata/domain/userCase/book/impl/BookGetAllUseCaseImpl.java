package com.fpmislata.domain.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.userCase.book.BookGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookGetAllUseCaseImpl implements BookGetAllUseCase {
    private final BookService bookAdminService;
    @Override
    public List<Book> getAll(int page, int size) {
        return bookAdminService.getAll(page, size);
    }
}
