package com.fpmislata.persistence.user.repository.impl;

import com.fpmislata.domain.user.entity.Book;
import com.fpmislata.persistence.user.repository.AuthorUserRepository;
import com.fpmislata.persistence.user.repository.BookUserRepository;
import com.fpmislata.persistence.user.repository.GenreUserRepository;
import com.fpmislata.persistence.user.repository.impl.mapper.BookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookUserRepositoryImpl implements BookUserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final AuthorUserRepository authorRepository;
    private final GenreUserRepository genreRepository;

    @Override
    public List<Book> getAll(int page, int size) {
        String sql = """
                SELECT * FROM books
                LIMIT ? OFFSET ?
                """;
        return jdbcTemplate.query(sql, new BookRowMapper(), size, page * size);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String sql = """
                     SELECT * FROM books
                     LEFT JOIN categories ON books.category_id = categories.id
                     LEFT JOIN publishers ON books.publisher_id = publishers.id
                     WHERE books.isbn = ?
                """;
        try {
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn);
            book.setAuthors(authorRepository.findByIsbn(isbn));
            book.setGenres(genreRepository.findByIsbn(isbn));
            return Optional.of(book);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int count() {
        String sql = """
                SELECT COUNT(*) FROM books
                """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
