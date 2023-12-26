package com.example.phoneStore.repository;

import com.example.phoneStore.entity.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhoneRepository extends MongoRepository<Phone, String> {
    List<Phone> findByPhoneNameLikeIgnoreCase(String name);
}
