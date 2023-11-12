package com.example.bookstore.service;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.request.CartRequest;
import com.example.bookstore.response.CartResponse;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<CartResponse> getCartByUserId(Long userId);

    ResponseEntity<BaseResponse> saveOrUpdateCart(CartRequest request);

    ResponseEntity<BaseResponse> paymentCart(Long userId);
}
