package com.example.phoneStore.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class KhachHang {
    @Id
    private String id;
    private String ten;
    private String sdt;
    private String gioitinh;
    private String diachi;
}
