package com.example.bookstore.response;

import com.example.bookstore.dto.BaseResponse;
import com.example.bookstore.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private BaseResponse payload;
    private List<Book> data;
}
