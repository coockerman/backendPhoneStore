package com.example.phoneStore.service;

import com.example.phoneStore.entity.Phone;
import com.example.phoneStore.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }
    public List<Phone> listAll() {
        return phoneRepository.findAll();
    }
    public void saveOrUpdate(Phone phone) {
        phoneRepository.save(phone);
    }
    public void deletePhone(String id) {
        phoneRepository.deleteById(id);
    }
    public Phone getStudentById(String phoneId) {
        return phoneRepository.findById(phoneId).get();
    }

    public List<Phone> findPhonesByName(String name) {
        return phoneRepository.findByPhoneNameLikeIgnoreCase(name);
    }
}