package com.ktt.controller;

import com.ktt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public void createUser(String email, String name, String password) {
        userService.createUser(email, name, password);
    }
}
