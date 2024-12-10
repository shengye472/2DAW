package com.fpMislata.persistence.dao.jdbc.mapper;

import com.fpMislata.domain.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setOrderDate(rs.getDate("order_date"));
        order.setDeliveryDate(rs.getDate("delivery_date"));
        order.setStatus(statusToString(rs.getInt("status")));
        order.setTotal(new BigDecimal(putBigDecimal(rs.getString("total"))));
        return order;
    }


    private String putBigDecimal(String total) {
        return total == null? "0" : total;
    }

    private String statusToString (int option) {
        switch (option) {
            case 0:
                return "Pending";
            case 1:
                return "Actuated";
            case 2:
                return "Cancelled";
            case 3:
                return "In transit";
            case 4:
                return "Delivered";
            default:
                return "Unknown";
        }
    }
}
