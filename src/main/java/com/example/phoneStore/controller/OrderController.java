package com.example.phoneStore.controller;

import com.example.phoneStore.entity.Order;
import com.example.phoneStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value="save")
    public Order submitOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}