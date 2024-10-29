package com.fpmislata.persistence.admin.repository;

import com.fpmislata.domain.admin.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookAdminRepository {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);
}
