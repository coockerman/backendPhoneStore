package com.example.phoneStore.controller;

import com.example.phoneStore.entity.User;
import com.example.phoneStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return userList;
    }
    @GetMapping("GetById/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }
    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody User user) {
        String kq = userService.authenticateUser(user.getUserName(), user.getPassword());
        return kq;
    }

    @PostMapping(value="/save")
    private String saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getUserName();
    }
    @PutMapping("/update/{id}")
    public Optional<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        Optional<User> kq = userService.updateUser(id, updatedUser);
        return kq;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
