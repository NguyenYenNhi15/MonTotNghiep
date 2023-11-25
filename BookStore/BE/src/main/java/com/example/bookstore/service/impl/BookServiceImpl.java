package com.example.bookstore.service.impl;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.request.BookRequest;
import com.example.bookstore.response.BookResponse;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repo;

    @Override
    public ResponseEntity<BookResponse> getAllBooks() {
        List<Book> books = repo.findAll();
        if (!books.isEmpty()) {
            BookResponse response = new BookResponse();
            response.setPayload(new BaseResponse(200, "Thành công"));
            response.setData(books);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(new BookResponse(new BaseResponse(201, "Không tìm thấy sách"), null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookResponse> getBookById(Long id) {
        List<Book> book = repo.findAllById(id);
        if (book != null) {
            BookResponse response = new BookResponse();
            response.setPayload(new BaseResponse(200, "Thành công"));
            response.setData(book);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(new BookResponse(new BaseResponse(201, "Không tìm thấy sách"), null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> saveOrUpdateBook(BookRequest request) {
        if (request != null) {
            Book book = repo.findByName(request.getName());
            if (book != null) {
                book.setId(book.getId());
            }
            book.setName(request.getName());
            book.setAuthor(request.getAuthor());
            book.setDescription(request.getDescription());
            book.setPrice(request.getPrice());
            book.setType(request.getType());
            book.setIsDelete(0L);
            repo.save(book);
            return new ResponseEntity<>(new BaseResponse(200, "Thành công"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(400, "Thông tin sách không chính xác"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> deleteBook(Long id) {
        if (id != null) {
            Book book = repo.findBookById(id);
            book.setIsDelete(1L);
            repo.save(book);
            return new ResponseEntity<>(new BaseResponse(200, "Thành công"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(400, "Không tìm thấy sách"), HttpStatus.OK);
    }
}
