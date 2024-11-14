package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.admin.userCase.book.BookAdminGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminGetAllUseCaseImpl implements BookAdminGetAllUseCase {
    private final BookAdminService bookAdminService;
    @Override
    public List<Book> getAll(int page, int size) {
        return bookAdminService.getAll(page, size);
    }
}
