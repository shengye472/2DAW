package com.fpMislata.persistence.dao.jdbc;

import com.fpMislata.domain.entity.Order;
import com.fpMislata.persistence.dao.OrderDao;
import com.fpMislata.persistence.dao.jdbc.mapper.OrderRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderDaoJdbc implements OrderDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserDaoJdbc userDaoJdbc;


    @Override
    public List<Order> getAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    @Override
    public Optional<Order> findById(Integer id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            Order order = jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
            order.setUser(userDaoJdbc.findById(order.getId()));
            return Optional.of(order);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}

