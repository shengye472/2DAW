package com.fpmislata.domain.useCase.book.common;

import com.fpmislata.domain.entity.Book;

import java.util.List;

public interface BookGetAllUseCase {

    List<Book> getAll(int i, int pageSize);
}
