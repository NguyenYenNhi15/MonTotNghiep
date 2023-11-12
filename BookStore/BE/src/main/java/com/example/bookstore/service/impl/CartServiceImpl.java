package com.example.bookstore.service.impl;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Cart;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CartRepository;
import com.example.bookstore.request.CartRequest;
import com.example.bookstore.response.CartResponse;
import com.example.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository repo;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<CartResponse> getCartByUserId(Long userId) {
        List<Cart> carts = repo.findAllByUserId(userId);
        if (!carts.isEmpty()) {
            List<Book> books = new ArrayList<>();
            for (int i = 0; i < carts.size(); i++) {
                Book book = bookRepository.findBookById(carts.get(i).getBookId());
                books.add(book);
            }
            CartResponse response = new CartResponse();
            response.setData(books);
            response.setPayload(new BaseResponse(200, "Thành công"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CartResponse(new BaseResponse(201, "Thất bại"), null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> saveOrUpdateCart(CartRequest request) {
        if (request != null) {
            Cart cart = new Cart();
            cart.setUserId(request.getUserId());
            cart.setBookId(request.getBookId());
            cart.setStatus(0);
            repo.save(cart);
            return new ResponseEntity<>(new BaseResponse(200, "Thành công"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(201, "Thất bại"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> paymentCart(Long userId) {
        List<Cart> carts = repo.findAllByUserId(userId);
        if (!carts.isEmpty()) {
            for (int i = 0; i < carts.size(); i++) {
                carts.get(i).setStatus(1);
            }
            repo.saveAll(carts);
            return new ResponseEntity<>(new BaseResponse(200, "Thành công"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(201, "Thất bại"), HttpStatus.OK);
    }
}
