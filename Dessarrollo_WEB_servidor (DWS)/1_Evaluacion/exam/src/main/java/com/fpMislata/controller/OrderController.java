package com.fpMislata.controller;

import com.fpMislata.controller.webmodel.OrderCollection;
import com.fpMislata.controller.webmodel.OrderMapper;
import com.fpMislata.domain.entity.Order;
import com.fpMislata.domain.usecase.OrderFindByIdUseCase;
import com.fpMislata.domain.usecase.OrderGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderGetAllUseCase orderGetAllUseCase;
    private final OrderFindByIdUseCase orderFindByIdUseCase;

    @GetMapping
    public ResponseEntity<List<OrderCollection>> getAll(){
        List<OrderCollection> orderCollectionList = orderGetAllUseCase
                .getAll()
                .stream()
                .map(OrderMapper.INSTANCE::toOrderCollection)
                .toList();
        return new ResponseEntity(orderCollectionList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id){
        Order order = orderFindByIdUseCase.findById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
