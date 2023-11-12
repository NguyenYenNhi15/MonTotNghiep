package com.example.bookstore.service;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.request.LoginRequest;
import com.example.bookstore.request.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<BaseResponse> login(LoginRequest request);

    ResponseEntity<BaseResponse> register(SignUpRequest request);
}
