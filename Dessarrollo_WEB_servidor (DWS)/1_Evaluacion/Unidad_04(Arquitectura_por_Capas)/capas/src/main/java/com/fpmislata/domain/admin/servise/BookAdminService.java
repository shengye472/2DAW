package com.fpmislata.domain.admin.servise;

import com.fpmislata.domain.admin.entity.Author;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.entity.Genre;

import java.util.List;

public interface BookAdminService {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Book findByIsbn(String isbn);

    Book findById(int id);

    void insertAuthors(Integer id, List<Author> authors);

    void insertGenres(Integer id, List<Genre> genres);
}
