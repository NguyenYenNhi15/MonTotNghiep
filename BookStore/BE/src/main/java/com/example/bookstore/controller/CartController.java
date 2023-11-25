package com.example.bookstore.controller;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.request.CartRequest;
import com.example.bookstore.response.CartResponse;
import com.example.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class CartController {
    @Autowired
    private CartService service;

    @GetMapping("/get-cart-by-user-id")
    public ResponseEntity<CartResponse> getCartByUserId(@RequestParam Long userId) {
        return service.getCartByUserId(userId);
    }

    @PostMapping("/save-or-update-cart")
    public ResponseEntity<BaseResponse> saveOrUpdateCart(@RequestBody CartRequest request) {
        return service.saveOrUpdateCart(request);
    }

    @GetMapping("/payment-cart")
    public ResponseEntity<BaseResponse> paymentCart(@RequestParam Long userId) {
        return service.paymentCart(userId);
    }
}
