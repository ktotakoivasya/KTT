package com.ktt.controller;

import com.ktt.service.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-in")
    public void createUser(String email, String name, String password) {
        userService.createUser(email, name, password);
    }
}
