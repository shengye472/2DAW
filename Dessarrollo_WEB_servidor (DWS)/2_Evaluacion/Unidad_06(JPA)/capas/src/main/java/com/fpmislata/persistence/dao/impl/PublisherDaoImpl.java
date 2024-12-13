package com.fpmislata.persistence.dao.impl;

import com.fpmislata.domain.entity.Publisher;
import com.fpmislata.persistence.dao.PublisherDao;
import com.fpmislata.persistence.dao.impl.mapper.PublisherRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PublisherDaoImpl implements PublisherDao {

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
