package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Genre;
import com.fpmislata.persistence.repository.GenreRepository;
import com.fpmislata.persistence.repository.impl.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> findByIsbn(String isbn) {
        String sql = """
               SELECT genres.* FROM genres
               INNER JOIN books_genres ON genres.id = books_genres.genre_id
               INNER JOIN books ON books_genres.book_id = books.id
               WHERE books.isbn = ?
               """;
        return jdbcTemplate.query(sql,new GenreRowMapper(),isbn);
    }
}
