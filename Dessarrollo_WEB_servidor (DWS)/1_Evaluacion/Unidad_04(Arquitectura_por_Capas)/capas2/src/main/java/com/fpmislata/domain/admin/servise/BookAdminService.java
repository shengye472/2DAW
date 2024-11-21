package com.fpmislata.domain.admin.servise;

import com.fpmislata.domain.admin.entity.Author;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface BookAdminService {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(int id);

    void addAuthor (Book book, Author author);

    void addGenre(Book book, Genre genre);

    void save(Book book);

//    void insertAuthors(Integer id, List<Author> authors);

//    void insertGenres(Integer id, List<Genre> genres);
}
