package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Author;
import com.fpmislata.persistence.repository.AuthorRepository;
import com.fpmislata.persistence.repository.impl.mapper.AuthorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Author> findByIsbn(String isbn)  {
        String sql = """
                SELECT authors.* FROM authors
                INNER JOIN books_authors ON authors.id = books_authors.author_id
                INNER JOIN books ON books_authors.book_id = books.id
                WHERE books.isbn = ?
                """;
        return jdbcTemplate.query(sql,new AuthorRowMapper(),isbn);
    }
}
