package com.fpmislata.domain.admin.servise;

import com.fpmislata.domain.admin.entity.Book;

import java.util.List;

public interface BookAdminService {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Book findByIsbn(String isbn);
}
