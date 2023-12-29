package com.example.phoneStore.repository;

import com.example.phoneStore.entity.KhachHang;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface KhachHangRepository extends MongoRepository<KhachHang, String> {
    Optional<KhachHang> findKhachHangBySdtLikeIgnoreCase(String sdt);
}
