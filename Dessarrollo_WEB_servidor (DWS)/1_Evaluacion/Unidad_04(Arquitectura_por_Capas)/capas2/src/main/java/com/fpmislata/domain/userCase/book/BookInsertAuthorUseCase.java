package com.fpmislata.domain.userCase.book;

import com.fpmislata.domain.entity.Author;

import java.util.List;

public interface BookInsertAuthorUseCase {
    void insertAuthors(Integer id, List<Author> authors);
}
