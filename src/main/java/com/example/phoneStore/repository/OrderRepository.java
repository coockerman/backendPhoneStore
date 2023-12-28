package com.example.phoneStore.repository;

import com.example.phoneStore.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
