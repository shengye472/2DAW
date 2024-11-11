package com.fpmislata.domain.admin.repository;

import com.fpmislata.domain.admin.entity.Author;

import java.util.List;

public interface AuthorAdminRepository {
    List<Author> getByIsbnBook(String isbn);

    List<Author> getByIdBook(long id);

    List<Author> findAllById(Long[] ids);
}
