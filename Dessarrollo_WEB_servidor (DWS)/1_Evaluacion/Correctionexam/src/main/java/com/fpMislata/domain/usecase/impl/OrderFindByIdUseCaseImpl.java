package com.fpMislata.domain.usecase.impl;

import com.fpMislata.common.annotation.DomainUseCase;
import com.fpMislata.common.exception.ResourceNotFoundException;
import com.fpMislata.domain.entity.Order;
import com.fpMislata.domain.service.OrderService;
import com.fpMislata.domain.usecase.OrderFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class OrderFindByIdUseCaseImpl implements OrderFindByIdUseCase {

    private final OrderService orderService;

    @Override
    public Order findById(Integer id) {
        return orderService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order Id: " + id + " not found"));
    }
}
