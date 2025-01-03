package com.fpmislata.controller.user.webModel.entity.book;

import java.math.BigDecimal;

public record BookCollection(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String cover
) {
}
