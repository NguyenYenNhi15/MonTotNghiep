package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book b WHERE b.id = ?1", nativeQuery = true)
    List<Book> findAllById(Long id);

    @Query(value = "SELECT * FROM book b WHERE b.name = ?1", nativeQuery = true)
    Book findByName(String name);

    @Query(value = "SELECT * FROM book b WHERE b.id = ?1", nativeQuery = true)
    Book findBookById(Long id);
}
