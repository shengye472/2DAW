package com.fpMislata.persistence.dao;

import com.fpMislata.domain.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> getAll();

    Optional<Order> findById(Integer id);
}
