package com.fpmislata.persistence.admin.impl;

import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.persistence.admin.AuthorAdminRepository;
import com.fpmislata.persistence.admin.BookAdminRepository;
import com.fpmislata.persistence.admin.GenreAdminRepository;
import com.fpmislata.persistence.admin.impl.mapper.BookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookAdminRepositoryImpl implements BookAdminRepository {

    private final JdbcTemplate jdbcTemplate;

    private final AuthorAdminRepository authorAdminRepository;
    private final GenreAdminRepository genreAdminRepository;


    @Override
    public List<Book> getAll() {
        String sql = """
                SELECT * FROM books
                """;
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public List<Book> getAll(int page, int size) {
        String sql = """
                   SELECT * FROM books
                   LIMIT ? OFFSET ?
                """;
        return jdbcTemplate.query(sql, new BookRowMapper(), size, page * size);
    }

    @Override
    public int count() {
        String sql = """
                   SELECT COUNT(*) FROM books
                """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
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
            book.setAuthors(authorAdminRepository.getByIsbnBook(isbn));
            book.setGenres(genreAdminRepository.getByIsbnBook(isbn));
            return Optional.of(book);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}