package com.example.phoneStore.service;

import com.example.phoneStore.entity.User;
import com.example.phoneStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveOrUpdate(User user) {
        if (!existsByUsername(user.getUserName())) {
            userRepository.save(user);
        } else {
            throw new RuntimeException("Username already exists");
        }
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUserName(username);
    }
    public String authenticateUser(String username, String password) {
        System.out.println(username);
        User user = userRepository.findUserByUserName(username);
        if(user != null && user.getPassword().equals(password)) {
            System.out.println(user.getChucVu());

            if(user.getChucVu()==null) return "false";
            System.out.println("pem");

            if(user.getChucVu().equals("QuanLy")) {
                return "QuanLy";
            }else{
                return "NhanVien";
            }
        }
        return "false";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUserName(updatedUser.getUserName());
                    existingUser.setPassword(updatedUser.getPassword());
                    existingUser.setTen(updatedUser.getTen());
                    existingUser.setDiaChi(updatedUser.getDiaChi());
                    existingUser.setSdt(updatedUser.getSdt());
                    existingUser.setChucVu(updatedUser.getChucVu());
                    existingUser.setGioiTinh(updatedUser.getGioiTinh());
                    return userRepository.save(existingUser);
                });
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }
}
