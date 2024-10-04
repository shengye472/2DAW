package com.fpmislata.persistence.repository;

import com.fpmislata.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll();

    Optional<Book> findByIsbn(String isbn);
}
