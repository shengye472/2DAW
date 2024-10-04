package com.fpmislata.persistence.repository;

import com.fpmislata.domain.entity.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> findByIsbn(String isbn);
}
