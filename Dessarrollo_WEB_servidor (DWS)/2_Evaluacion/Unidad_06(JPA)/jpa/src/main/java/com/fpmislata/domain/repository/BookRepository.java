package com.fpmislata.domain.repository;

import com.fpmislata.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(int id);

    void save(Book book);
}
