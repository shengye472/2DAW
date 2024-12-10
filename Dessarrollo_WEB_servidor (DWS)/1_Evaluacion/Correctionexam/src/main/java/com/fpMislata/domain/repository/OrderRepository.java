package com.fpMislata.domain.repository;

import com.fpMislata.domain.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> getAll();

    Optional<Order> findById(Integer id);
}
