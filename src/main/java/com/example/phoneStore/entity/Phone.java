package com.example.phoneStore.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Phone {
    @Id
    private String _id;
    private String phoneName;
    private String phoneType;
    private String phoneColor;
    private Long phonePrice;
}
