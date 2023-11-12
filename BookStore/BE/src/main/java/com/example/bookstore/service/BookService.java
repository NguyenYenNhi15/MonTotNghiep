package com.example.bookstore.service;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.request.BookRequest;
import com.example.bookstore.response.BookResponse;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<BookResponse> getAllBooks();

    ResponseEntity<BookResponse> getBookById(Long id);

    ResponseEntity<BaseResponse> saveOrUpdateBook(BookRequest request);

    ResponseEntity<BaseResponse> deleteBook(Long id);
}
