package com.fpmislata.domain.useCase.book.admin;

import com.fpmislata.domain.entity.Author;

import java.util.List;

public interface BookInsertAuthorUseCase {
    void insertAuthors(Integer id, List<Author> authors);
}
