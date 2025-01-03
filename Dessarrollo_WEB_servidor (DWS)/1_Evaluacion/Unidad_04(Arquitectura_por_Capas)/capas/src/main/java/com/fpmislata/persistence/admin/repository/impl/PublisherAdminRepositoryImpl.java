package com.fpmislata.persistence.admin.repository.impl;

import com.fpmislata.domain.admin.entity.Publisher;
import com.fpmislata.domain.admin.repository.PublisherAdminRepository;
import com.fpmislata.persistence.admin.repository.impl.mapper.PublisherRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PublisherAdminRepositoryImpl implements PublisherAdminRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Publisher> findById(long id) {
        String sql = """
                SELECT * FROM publishers
                WHERE id = ?
                """;
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new PublisherRowMapper(),id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
