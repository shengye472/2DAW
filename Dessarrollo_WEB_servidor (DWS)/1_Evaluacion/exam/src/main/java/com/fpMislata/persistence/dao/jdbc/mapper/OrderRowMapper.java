package com.fpMislata.persistence.dao.jdbc.mapper;

import com.fpMislata.domain.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("orders.id"));
        order.setOrderDate(rs.getString("orders.order_date"));
        order.setDeliveryDate(rs.getString("orders.delivery_date"));
        order.setStatus(toStatusString(rs.getInt("orders.status")));
        order.setTotal(rs.getFloat("orders.total"));
        order.setUser(null);
        order.setOrderDetail(null);
        return order;
    }

    private String toStatusString(int option) {
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
