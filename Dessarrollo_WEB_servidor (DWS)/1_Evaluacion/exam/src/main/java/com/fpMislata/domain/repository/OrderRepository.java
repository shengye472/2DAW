package com.fpMislata.domain.repository;

import com.fpMislata.domain.entity.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAll();
}
