package com.fpMislata.persistence.repository.impl;

import com.fpMislata.domain.entity.Order;
import com.fpMislata.domain.repository.OrderRepository;
import com.fpMislata.persistence.dao.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderDao orderDao;

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderDao.findById(id);
    }
}
