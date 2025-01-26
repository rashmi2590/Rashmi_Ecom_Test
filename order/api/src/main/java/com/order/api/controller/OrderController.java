package com.order.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.api.entity.Order;
import com.order.api.service.OrderService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService productService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        log.info("Inside OrderController === createOrder()");
        
        return ResponseEntity.ok(productService.createOrder(order));
    }
   

}
