package com.fpmislata.persistence.admin.repository.impl;

import com.fpmislata.domain.admin.entity.Genre;
import com.fpmislata.domain.admin.repository.GenreAdminRepository;
import com.fpmislata.persistence.admin.repository.impl.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class GenreAdminRepositoryImpl implements GenreAdminRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Genre> getByIsbnBook(String isbn) {
        String sql = """
                SELECT genres.* FROM genres
                JOIN books_genres ON genres.id = books_genres.genre_id
                JOIN books ON books_genres.book_id = books.id
                AND books.isbn = ?
               """;
        return jdbcTemplate.query(sql, new GenreRowMapper(), isbn);
    }

    @Override
    public List<Genre> getByIdBook(long id) {
        String sql = """
                SELECT genres.* FROM genres
                JOIN books_genres ON genres.id = books_genres.genre_id
                JOIN books ON books_genres.book_id = books.id
                AND books.id = ?
               """;
        return jdbcTemplate.query(sql, new GenreRowMapper(), id);
    }

    @Override
    public List<Genre> findAllById(Long[] ids) {
        String sql = """
                SELECT * FROM genres
                WHERE id IN (:ids)
                """;
        Map<String, List<Long>> params = Map.of("ids", Arrays.asList(ids));
        return namedParameterJdbcTemplate.query(sql,params,new GenreRowMapper());
    }
}
