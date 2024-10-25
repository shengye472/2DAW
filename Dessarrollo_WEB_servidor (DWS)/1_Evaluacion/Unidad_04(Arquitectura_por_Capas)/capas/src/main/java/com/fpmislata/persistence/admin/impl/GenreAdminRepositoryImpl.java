package com.fpmislata.persistence.admin.impl;

import com.fpmislata.domain.admin.entity.Genre;
import com.fpmislata.persistence.admin.GenreAdminRepository;
import com.fpmislata.persistence.admin.impl.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreAdminRepositoryImpl implements GenreAdminRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> getByIsbnBook(String isbn) {
        String sql = """
               SELECT genres.* FROM genres
               INNER JOIN books_genres ON genres.id = books_genres.genre_id
               INNER JOIN books ON books_genres.book_id = books.id
               WHERE books.isbn = ?
               """;
        return jdbcTemplate.query(sql, new GenreRowMapper());
    }
}
