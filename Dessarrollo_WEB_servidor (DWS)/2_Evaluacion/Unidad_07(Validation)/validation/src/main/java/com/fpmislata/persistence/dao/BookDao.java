package com.fpmislata.persistence.dao;

import com.fpmislata.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(long id);

    void save(Book book);

    void deleteById(Long id);
}
