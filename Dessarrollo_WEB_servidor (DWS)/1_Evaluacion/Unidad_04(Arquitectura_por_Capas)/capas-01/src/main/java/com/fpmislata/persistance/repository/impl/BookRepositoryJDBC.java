package com.fpmislata.persistance.repository.impl;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.repository.BookRepository;
import com.fpmislata.persistance.repository.mapper.BookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class BookRepositoryJDBC implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAll()
    {
        String sql = """
                        SELECT * FROM books
                     """;
        return jdbcTemplate.query(sql,new BookRowMapper());
    }

//    @Override
//    public Optional<Book> findByIsbn(String isbn) {
//        return null;
//    }
}
