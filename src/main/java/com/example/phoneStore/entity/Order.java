package com.example.phoneStore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
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

    // Constructors, getters, and setters
}
