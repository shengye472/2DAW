package com.fpmislata.persistence.admin.repository.impl;

import com.fpmislata.domain.admin.entity.Author;
import com.fpmislata.persistence.admin.repository.AuthorAdminRepository;
import com.fpmislata.persistence.admin.repository.impl.mapper.AuthorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorAdminRepositoryImpl implements AuthorAdminRepository {

    private final JdbcTemplate jdbcTemplate;

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
}
