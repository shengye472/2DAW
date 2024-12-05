package com.fpMislata.persistence.dao;

import com.fpMislata.domain.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAll();
}
