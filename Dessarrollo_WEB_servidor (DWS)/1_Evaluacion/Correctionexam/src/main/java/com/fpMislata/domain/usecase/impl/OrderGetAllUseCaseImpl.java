package com.fpMislata.domain.usecase.impl;

import com.fpMislata.common.annotation.DomainUseCase;
import com.fpMislata.domain.entity.Order;
import com.fpMislata.domain.service.OrderService;
import com.fpMislata.domain.usecase.OrderGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class OrderGetAllUseCaseImpl implements OrderGetAllUseCase {

    private final OrderService orderService;

    @Override
    public List<Order> getAll() {
        return orderService.getAll();
    }
}
