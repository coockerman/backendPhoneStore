package com.example.phoneStore.repository;

import com.example.phoneStore.entity.NhaCungCap;
import com.example.phoneStore.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface NhaCungCapRepository extends MongoRepository<NhaCungCap, String> {
}
