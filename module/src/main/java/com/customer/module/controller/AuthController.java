package com.customer.module.controller;

import com.customer.module.dto.AuthResponse;
import com.customer.module.dto.LoginRequest;
import com.customer.module.dto.RegisterRequest;
import com.customer.module.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
