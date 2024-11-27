package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Category;
import com.fpmislata.domain.repository.CategoryRepository;
import com.fpmislata.persistence.repository.impl.mapper.CategoryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Category> findById(long id) {
        String sql = """
                SELECT * FROM categories
                WHERE id = ?
                """;
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql,new CategoryRowMapper(),id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
