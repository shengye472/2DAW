package com.fpMislata.controller.webmodel;

import com.fpMislata.domain.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderCollection toOrderCollection(Order order);
}
