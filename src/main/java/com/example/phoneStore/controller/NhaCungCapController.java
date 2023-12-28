package com.example.phoneStore.controller;

import com.example.phoneStore.entity.NhaCungCap;
import com.example.phoneStore.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1/NCC")
public class NhaCungCapController {

    private final NhaCungCapService nhaCungCapService;

    @Autowired
    public NhaCungCapController(NhaCungCapService nhaCungCapService) {
        this.nhaCungCapService = nhaCungCapService;
    }

    @GetMapping("/getAll")
    public List<NhaCungCap> getAllNhaCungCaps() {
        return nhaCungCapService.getAllNhaCungCaps();
    }

    @PostMapping("/save")
    public NhaCungCap saveNhaCungCap(@RequestBody NhaCungCap nhaCungCap) {
        return nhaCungCapService.addNhaCungCap(nhaCungCap);
    }

    @PutMapping("/edit/{id}")
    public NhaCungCap updateNhaCungCap(
            @RequestBody NhaCungCap nhaCungCap, @PathVariable(name = "id") String id) {
        return nhaCungCapService.updateNhaCungCap(id, nhaCungCap)
                .orElseThrow(() -> new RuntimeException("NhaCungCap not found with id: " + id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNhaCungCap(@PathVariable(name = "id") String id) {
        nhaCungCapService.deleteNhaCungCap(id);
    }

    @GetMapping("/search/{id}")
    public NhaCungCap getNhaCungCap(@PathVariable(name = "id") String id) {
        return nhaCungCapService.getNhaCungCapById(id)
                .orElseThrow(() -> new RuntimeException("NhaCungCap not found with id: " + id));
    }


}
