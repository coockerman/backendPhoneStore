package com.example.phoneStore.controller;

import com.example.phoneStore.entity.Phone;
import com.example.phoneStore.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        // Khởi tạo thời gian hiện tại
        LocalDateTime currentTime = LocalDateTime.now();

        // Gán thời gian hiện tại vào thuộc tính purchaseTime
        phone.setPurchaseTime(currentTime);

        // Lưu vào cơ sở dữ liệu
        phoneService.saveOrUpdate(phone);

        return phone.get_id();
    }

    @PutMapping(value="/edit/{id}")
    private Phone update(@RequestBody Phone updatedPhone, @PathVariable(name="id")String _id) {
        // Lấy ra đối tượng cần cập nhật từ cơ sở dữ liệu
        Phone existingPhone = phoneService.getPhoneById(_id);

        // Kiểm tra nếu đối tượng tồn tại
        if (existingPhone != null) {
            // Cập nhật các trường, trừ trường thời gian
            existingPhone.setPhoneName(updatedPhone.getPhoneName());
            existingPhone.setPhoneType(updatedPhone.getPhoneType());
            existingPhone.setPhoneColor(updatedPhone.getPhoneColor());
            existingPhone.setNcc(updatedPhone.getNcc());
            existingPhone.setPhonePrice(updatedPhone.getPhonePrice());

            // Lưu đối tượng đã cập nhật vào cơ sở dữ liệu
            phoneService.saveOrUpdate(existingPhone);
        }

        return existingPhone;
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
