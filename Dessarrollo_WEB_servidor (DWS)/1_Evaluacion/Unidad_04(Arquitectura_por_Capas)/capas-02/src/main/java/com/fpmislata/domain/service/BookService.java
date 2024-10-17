package com.fpmislata.domain.service;

import com.fpmislata.domain.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll(int page, int size);

    Book findByIsbn(String isbn);

    int count();
}
