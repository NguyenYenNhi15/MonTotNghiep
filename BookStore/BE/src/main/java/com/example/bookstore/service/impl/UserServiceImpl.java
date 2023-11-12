package com.example.bookstore.service.impl;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.entity.User;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.request.LoginRequest;
import com.example.bookstore.request.SignUpRequest;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public ResponseEntity<BaseResponse> login(LoginRequest request) {
        if (request != null && request.getUsername() != null) {
            User user = repo.findByUsername(request.getUsername());
            if (user != null) {
                if (user.getPassword().equals(request.getPassword())) {
                    return new ResponseEntity<>(new BaseResponse(200, "Đăng nhập thành công"), HttpStatus.OK);
                }
                return new ResponseEntity<>(new BaseResponse(201, "Thông tin tài khoản hoặc mật khẩu không chính xác"), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new BaseResponse(400, "Không tìm thấy tài khoản"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> register(SignUpRequest request) {
        if (request != null) {
            User user = repo.findByUsername(request.getUsername());
            if (user != null) {
                return new ResponseEntity<>(new BaseResponse(202, "Tài khoản đã tồn tại"), HttpStatus.OK);
            } else {
                User userNew = new User();
                userNew.setName(request.getName());
                userNew.setPhoneNumber(request.getPhoneNumber());
                userNew.setEmail(request.getEmail());
                userNew.setAddress(request.getAddress());
                userNew.setUsername(request.getUsername());
                userNew.setPassword(request.getPassword());
                repo.save(userNew);
                return new ResponseEntity<>(new BaseResponse(200, "Đăng ký thành công"), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new BaseResponse(400, "Đăng ký thất bại"), HttpStatus.OK);
    }
}
