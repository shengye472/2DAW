package com.fpMislata.domain.service;

import com.fpMislata.domain.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAll();

    Optional<Order> findById(Integer id);
}
