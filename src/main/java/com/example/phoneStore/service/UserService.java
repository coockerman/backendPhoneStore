package com.example.phoneStore.service;

import com.example.phoneStore.entity.User;
import com.example.phoneStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            // Người dùng đã tồn tại, bạn có thể xử lý tùy ý, ví dụ: throw exception hoặc trả về thông báo lỗi.
            // Ở đây, tôi sẽ trả về một Exception.
            throw new RuntimeException("Username already exists");
        }
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUserName(username);
    }
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findUserByUserName(username);

        return user != null && user.getPassword().equals(password);
    }
}
