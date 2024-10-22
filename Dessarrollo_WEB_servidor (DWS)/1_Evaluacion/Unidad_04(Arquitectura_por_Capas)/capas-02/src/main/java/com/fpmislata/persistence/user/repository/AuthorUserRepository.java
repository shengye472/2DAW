package com.fpmislata.persistence.user.repository;

import com.fpmislata.domain.user.entity.Author;

import java.util.List;

public interface AuthorUserRepository {
    List<Author> findByIsbn(String isbn);
}
