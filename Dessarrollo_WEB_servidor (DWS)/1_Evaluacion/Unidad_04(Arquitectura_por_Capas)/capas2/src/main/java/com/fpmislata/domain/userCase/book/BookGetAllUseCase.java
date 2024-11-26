package com.fpmislata.domain.userCase.book;

import com.fpmislata.domain.entity.Book;

import java.util.List;

public interface BookGetAllUseCase {
    List<Book> getAll(int page, int size);
}
