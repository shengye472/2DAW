package com.fpmislata.persistence.user.repository;

import com.fpmislata.domain.user.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookUserRepository {
    List<Book> getAll(int page, int size);

    Optional<Book> findByIsbn(String isbn);

    int count();
}
