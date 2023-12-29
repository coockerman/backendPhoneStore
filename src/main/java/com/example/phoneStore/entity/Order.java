package com.example.phoneStore.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Order {
    @Id
    private String id;

    private String customerName;
    private String salespersonName;
    private String storeName;
    private String paymentMethod;
    private List<Phone> selectedPhones;
    private LocalDateTime orderTime; // Thêm biến thời gian

    // Constructors, getters, and setters
}
