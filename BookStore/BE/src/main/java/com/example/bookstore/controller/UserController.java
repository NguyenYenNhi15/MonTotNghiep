package com.example.bookstore.controller;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.request.LoginRequest;
import com.example.bookstore.request.SignUpRequest;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse> signUp(@RequestBody SignUpRequest request) {
        return service.register(request);
    }
}
