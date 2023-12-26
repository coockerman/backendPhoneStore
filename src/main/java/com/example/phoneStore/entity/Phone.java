package com.example.phoneStore.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Document
public class Phone {
    @Id
    private String _id;
    private String phoneName;
    private String phoneType;
    private String phoneColor;
    private Long phonePrice;

    public Phone(String phoneName, String phoneType, String phoneColor, Long phonePrice) {
        this.phoneName = phoneName;
        this.phoneType = phoneType;
        this.phoneColor = phoneColor;
        this.phonePrice = phonePrice;
    }
}
