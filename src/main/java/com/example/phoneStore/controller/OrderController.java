package com.example.phoneStore.controller;

import com.example.phoneStore.entity.Order;
import com.example.phoneStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value="save")
    public Order submitOrder(@RequestBody Order order) {
        // Thêm thời gian hiện tại khi tạo đối tượng Order
        order.setOrderTime(LocalDateTime.now());
        return orderService.saveOrder(order);
    }

    @GetMapping("/getAll")
    public List<Order> getAllHoaDon() {
        return orderService.listAll();
    }
}
