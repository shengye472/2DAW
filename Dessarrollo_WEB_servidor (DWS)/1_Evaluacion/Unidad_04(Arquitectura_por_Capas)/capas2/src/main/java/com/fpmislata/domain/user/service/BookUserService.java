package com.fpmislata.domain.user.service;

import com.fpmislata.domain.user.entity.Book;

import java.util.List;

public interface BookUserService {
    List<Book> getAll(int page, int size);

    Book findByIsbn(String isbn);

    int count();
}
