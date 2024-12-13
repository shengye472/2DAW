package com.fpmislata.persistence.dao.impl;

import com.fpmislata.domain.entity.Category;
import com.fpmislata.persistence.dao.CategoryDao;
import com.fpmislata.persistence.dao.impl.mapper.CategoryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {
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
