package com.example.phoneStore.controller;

import com.example.phoneStore.entity.KhachHang;
import com.example.phoneStore.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1/KH")
public class KhachHangController {

    private final KhachHangService khachHangService;

    @Autowired
    public KhachHangController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @GetMapping("/getAll")
    public List<KhachHang> getAllKhachHangs() {
        return khachHangService.getAllKhachHangs();
    }

    @PostMapping("/save")
    public KhachHang saveKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangService.addKhachHang(khachHang);
    }

    @PutMapping("/edit/{id}")
    public KhachHang updateKhachHang(
            @RequestBody KhachHang khachHang, @PathVariable(name = "id") String id) {
        return khachHangService.updateKhachHang(id, khachHang)
                .orElseThrow(() -> new RuntimeException("KhachHang not found with id: " + id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKhachHang(@PathVariable(name = "id") String id) {
        khachHangService.deleteKhachHang(id);
    }

    @GetMapping("/search/{id}")
    public KhachHang getKhachHang(@PathVariable(name = "id") String id) {
        return khachHangService.getKhachHangById(id)
                .orElseThrow(() -> new RuntimeException("KhachHang not found with id: " + id));
    }
    @GetMapping("/searchBySdt/{sdt}")
    public KhachHang getKhachHangBySdt(@PathVariable(name = "sdt") String sdt) {
        return khachHangService.getKhachHangBySdt(sdt)
                .orElseThrow(() -> new RuntimeException("KhachHang not found with SDT: " + sdt));
    }
}

