package com.fpMislata.domain.usecase.impl;

import com.fpMislata.common.annotation.DomainUseCase;
import com.fpMislata.domain.servise.OrderService;
import com.fpMislata.domain.usecase.OrderFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class OrderFindByIdUseCaseImpl implements OrderFindByIdUseCase {
    private final OrderService orderService;
}
