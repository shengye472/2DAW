package com.fpmislata.domain.useCase.book.admin;

import com.fpmislata.domain.entity.Book;

import java.util.List;

public interface BookGetAllAdminUseCase {
    List<Book> getAll(int page, int size);
}
