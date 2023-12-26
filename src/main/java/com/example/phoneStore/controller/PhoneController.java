package com.example.phoneStore.controller;

import com.example.phoneStore.entity.Phone;
import com.example.phoneStore.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/student")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping(value = "/getAllPhone")
    public List<Phone> getPhones() {
        return phoneService.listAll();
    }

    @PostMapping(value="/save")
    private String savPhone(@RequestBody Phone phone) {
        phoneService.saveOrUpdate(phone);
        return phone.get_id();
    }

    @PutMapping(value="/edit/{id}")
    private Phone update(@RequestBody Phone phone, @PathVariable(name="id")String _id) {
        phone.set_id(_id);
        phoneService.saveOrUpdate(phone);
        return phone;
    }

    @DeleteMapping(value="/delete/{id}")
    private void deletePhone(@PathVariable(name="id")String _id) {
        phoneService.deletePhone(_id);
    }

    @RequestMapping("/search/{id}")
    private Phone getPhone(@PathVariable(name="id")String phoneId) {
        return phoneService.getStudentById(phoneId);
    }
    @GetMapping("/search/{name}")
    private List<Phone> searchPhones(@PathVariable(name = "name") String name) {
        return phoneService.findPhonesByName(name);
    }
}
