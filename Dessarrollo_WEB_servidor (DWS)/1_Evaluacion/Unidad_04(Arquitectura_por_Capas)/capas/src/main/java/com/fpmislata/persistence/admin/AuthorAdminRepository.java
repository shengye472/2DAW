package com.fpmislata.persistence.admin;

import com.fpmislata.domain.admin.entity.Author;

import java.util.List;

public interface AuthorAdminRepository {
    List<Author> getByIsbnBook(String isbn);
}