package com.fpmislata.persistence.dao;

import com.fpmislata.domain.entity.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getByIsbnBook(String isbn);

    List<Author> getByIdBook(long id);

    List<Author> findAllById(Long[] ids);
}
