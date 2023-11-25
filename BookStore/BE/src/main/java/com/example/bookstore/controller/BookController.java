package com.example.bookstore.controller;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.request.BookRequest;
import com.example.bookstore.response.BookResponse;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/get-all-books")
    public ResponseEntity<BookResponse> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/get-book-by-id")
    public ResponseEntity<BookResponse> getBookById(@RequestParam Long id) {
        return service.getBookById(id);
    }

    @PostMapping("/save-or-update-book")
    public ResponseEntity<BaseResponse> saveOrUpdateBook(@RequestBody BookRequest request) {
        return service.saveOrUpdateBook(request);
    }

    @PostMapping("/delete-book")
    public ResponseEntity<BaseResponse> deleteBook(@RequestParam Long id) {
        return service.deleteBook(id);
    }
}
