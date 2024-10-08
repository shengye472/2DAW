package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.persistence.repository.AuthorRepository;
import com.fpmislata.persistence.repository.BookRepository;
import com.fpmislata.persistence.repository.GenreRepository;
import com.fpmislata.persistence.repository.impl.mapper.BookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public List<Book> getAll() {
        String sql = """
                SELECT * FROM books
                """;
        return jdbcTemplate.query(sql, new BookRowMapper());
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
}
