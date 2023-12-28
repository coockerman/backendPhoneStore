package com.example.phoneStore.service;

import com.example.phoneStore.entity.NhaCungCap;
import com.example.phoneStore.repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapService {
    private final NhaCungCapRepository nhaCungCapRepository;

    @Autowired
    public NhaCungCapService(NhaCungCapRepository nhaCungCapRepository) {
        this.nhaCungCapRepository = nhaCungCapRepository;
    }

    public List<NhaCungCap> getAllNhaCungCaps() {
        return nhaCungCapRepository.findAll();
    }

    public Optional<NhaCungCap> getNhaCungCapById(String id) {
        return nhaCungCapRepository.findById(id);
    }

    public NhaCungCap addNhaCungCap(NhaCungCap nhaCungCap) {
        return nhaCungCapRepository.save(nhaCungCap);
    }

    public Optional<NhaCungCap> updateNhaCungCap(String id, NhaCungCap updatedNhaCungCap) {
        return nhaCungCapRepository.findById(id)
                .map(existingNhaCungCap -> {
                    existingNhaCungCap.setTen(updatedNhaCungCap.getTen());
                    existingNhaCungCap.setSdt(updatedNhaCungCap.getSdt());
                    existingNhaCungCap.setAddress(updatedNhaCungCap.getAddress());
                    return nhaCungCapRepository.save(existingNhaCungCap);
                });
    }

    public void deleteNhaCungCap(String id) {
        nhaCungCapRepository.findById(id)
                .ifPresent(existingNhaCungCap -> nhaCungCapRepository.delete(existingNhaCungCap));
    }
}

