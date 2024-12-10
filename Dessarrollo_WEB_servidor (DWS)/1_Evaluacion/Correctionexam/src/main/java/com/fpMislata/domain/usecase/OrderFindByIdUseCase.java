package com.fpMislata.domain.usecase;

import com.fpMislata.domain.entity.Order;

public interface OrderFindByIdUseCase {
    Order findById(Integer id);
}
