package com.fpMislata.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private Date orderDate;
    private Date deliveryDate;
    private String status;
    private BigDecimal total;
    private User user;
    private List<OrderDetail> orderDetails;
}
