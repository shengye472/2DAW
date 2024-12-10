package com.fpMislata.persistence.dao.jdbc;

import com.fpMislata.domain.entity.User;
import com.fpMislata.persistence.dao.UserDao;
import com.fpMislata.persistence.dao.jdbc.mapper.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDaoJdbc implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public User findById(Integer orderId) {
        String sql = """
                SELECT * FROM users
                LEFT JOIN orders ON users.id = orders.user_id
                WHERE orders.id = ?
                """;
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), orderId);
    }
}
