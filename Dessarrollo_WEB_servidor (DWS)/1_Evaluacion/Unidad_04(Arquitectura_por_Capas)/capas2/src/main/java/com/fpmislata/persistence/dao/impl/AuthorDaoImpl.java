package com.fpmislata.persistence.dao.impl;

import com.fpmislata.domain.entity.Author;
import com.fpmislata.persistence.dao.AuthorDao;
import com.fpmislata.persistence.dao.impl.mapper.AuthorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Author> getByIsbnBook(String isbn) {
        String sql = """
                SELECT authors.* FROM authors
                Inner JOIN books_authors ON authors.id = books_authors.author_id
                Inner JOIN books ON books_authors.book_id = books.id
                WHERE books.isbn = ?
                """;
        return jdbcTemplate.query(sql,new AuthorRowMapper(),isbn);
    }

    @Override
    public List<Author> getByIdBook(long id) {
        String sql = """
                SELECT authors.* FROM authors
                Inner JOIN books_authors ON authors.id = books_authors.author_id
                Inner JOIN books ON books_authors.book_id = books.id
                WHERE books.id = ?
                """;
        return jdbcTemplate.query(sql,new AuthorRowMapper(),id);
    }

    @Override
    public List<Author> findAllById(Long[] ids) {
        String sql = """
                SELECT * FROM authors
                WHERE id IN (:ids)
                """;
        Map<String, List<Long>> params = Map.of("ids", Arrays.asList(ids));
        return namedParameterJdbcTemplate.query(sql, params, new AuthorRowMapper());
    }
}
