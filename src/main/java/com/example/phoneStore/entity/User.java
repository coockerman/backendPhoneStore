package com.example.phoneStore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private String ten;
    private String diaChi;
    private String sdt;
    private String chucVu;
    private String gioiTinh;
}
