package com.fpmislata.exam.domain.usecase;

import com.fpmislata.exam.domain.model.Book;

import java.util.List;

public interface BookFindAllUseCase {
    List<Book> findAll();
}
