package com.fpMislata.controller.webmodel;

import java.math.BigDecimal;
import java.util.Date;

public record OrderCollection(
        Integer id,
        Date orderDate,
        Date deliveryDate,
        String status,
        BigDecimal total
) {
}
