package com.fpmislata.domain.repository;

import com.fpmislata.domain.entity.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> getByIsbnBook(String isbn);

    List<Author> getByIdBook(long id);

    List<Author> findAllById(Long[] ids);
}
