package com.fpmislata.domain.admin.userCase.book;

import com.fpmislata.domain.admin.entity.Author;

import java.util.List;

public interface BookAdminInsertAuthorUseCase {
    void insertAuthors(Integer id, List<Author> authors);
}
