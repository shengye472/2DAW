package com.fpMislata.persistence.repository.impl;

import com.fpMislata.domain.entity.Order;
import com.fpMislata.domain.repository.OrderRepository;
import com.fpMislata.persistence.dao.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderDao orderDao;

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
