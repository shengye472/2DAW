package com.fpmislata.domain.servise;

import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(long id);

    void addAuthor (Book book, Author author);

    void addGenre(Book book, Genre genre);

    void save(Book book);

    void deleteById(Long id);

//    void insertAuthors(Integer id, List<AuthorUser> authors);

//    void insertGenres(Integer id, List<GenreUser> genres);
}
