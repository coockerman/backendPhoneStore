package com.example.phoneStore.controller;

import com.example.phoneStore.entity.User;
import com.example.phoneStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody User user) {
        if (userService.authenticateUser(user.getUserName(), user.getPassword())) {
            return "true";
        } else {
            return "false";
        }
    }

    @PostMapping(value="/save")
    private String saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getUserName();
    }

}
