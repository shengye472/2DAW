package com.fpmislata.persistence.admin.repository;

import com.fpmislata.domain.admin.entity.Author;

import java.util.List;

public interface AuthorAdminRepository {
    List<Author> getByIsbnBook(String isbn);
}
