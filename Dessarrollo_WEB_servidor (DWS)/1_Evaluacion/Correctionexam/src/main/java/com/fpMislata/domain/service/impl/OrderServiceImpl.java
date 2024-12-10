package com.fpMislata.domain.service.impl;

import com.fpMislata.common.annotation.DomainService;
import com.fpMislata.domain.entity.Order;
import com.fpMislata.domain.repository.OrderRepository;
import com.fpMislata.domain.service.OrderService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }
}
