package com.fpmislata.domain.admin.servise;

import com.fpmislata.domain.entity.Author;

import java.util.List;

public interface AuthorAdminService {
    List<Author> findAllById(List<Author> authors);
}
