package com.example.phoneStore.service;

import com.example.phoneStore.entity.Order;
import com.example.phoneStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> listAll() {
        return orderRepository.findAll();
    }
}