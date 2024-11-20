package com.fpmislata.persistence.admin.repository.impl;

import com.fpmislata.domain.admin.entity.Category;
import com.fpmislata.domain.admin.repository.CategoryAdminRepository;
import com.fpmislata.persistence.admin.repository.impl.mapper.CategoryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryAdminRepositoryImpl implements CategoryAdminRepository {
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
