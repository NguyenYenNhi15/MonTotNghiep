package com.example.bookstore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
