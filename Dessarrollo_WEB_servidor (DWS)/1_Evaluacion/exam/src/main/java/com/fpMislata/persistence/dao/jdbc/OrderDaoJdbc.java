package com.fpMislata.persistence.dao.jdbc;

import com.fpMislata.domain.entity.Order;
import com.fpMislata.persistence.dao.OrderDao;
import com.fpMislata.persistence.dao.jdbc.mapper.OrderRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDaoJdbc implements OrderDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getAll() {
        String sql = """
                SELECT * FROM orders
                """;
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }
}
