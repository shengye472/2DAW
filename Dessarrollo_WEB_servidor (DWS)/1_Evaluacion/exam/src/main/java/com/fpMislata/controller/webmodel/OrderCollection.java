package com.fpMislata.controller.webmodel;


public record OrderCollection(
        Integer id,
        String orderDete,
        String deliveryDate,
        String status,
        float total
) {
}
