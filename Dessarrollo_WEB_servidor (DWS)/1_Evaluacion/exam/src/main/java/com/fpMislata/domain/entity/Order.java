package com.fpMislata.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private String orderDate;
    private String deliveryDate;
    private String status;
    private float total;
    private User user;
    private OrderDetail orderDetail;
}
