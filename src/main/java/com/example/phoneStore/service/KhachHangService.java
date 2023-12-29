package com.example.phoneStore.service;

import com.example.phoneStore.entity.KhachHang;
import com.example.phoneStore.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    private final KhachHangRepository khachHangRepository;

    @Autowired
    public KhachHangService(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    public List<KhachHang> getAllKhachHangs() {
        return khachHangRepository.findAll();
    }

    public Optional<KhachHang> getKhachHangById(String id) {
        return khachHangRepository.findById(id);
    }

    public KhachHang addKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    public Optional<KhachHang> updateKhachHang(String id, KhachHang updatedKhachHang) {
        return khachHangRepository.findById(id)
                .map(existingKhachHang -> {
                    existingKhachHang.setTen(updatedKhachHang.getTen());
                    existingKhachHang.setSdt(updatedKhachHang.getSdt());
                    existingKhachHang.setGioitinh(updatedKhachHang.getGioitinh());
                    existingKhachHang.setDiachi(updatedKhachHang.getDiachi());
                    return khachHangRepository.save(existingKhachHang);
                });
    }

    public void deleteKhachHang(String id) {
        khachHangRepository.findById(id)
                .ifPresent(existingKhachHang -> khachHangRepository.delete(existingKhachHang));
    }
    public Optional<KhachHang> getKhachHangBySdt(String sdt) {
        return khachHangRepository.findKhachHangBySdtLikeIgnoreCase(sdt);
    }
}

