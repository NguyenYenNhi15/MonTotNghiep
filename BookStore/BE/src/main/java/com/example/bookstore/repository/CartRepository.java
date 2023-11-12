package com.example.bookstore.repository;

import com.example.bookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "SELECT * FROM cart c WHERE c.user_id = ?1 AND c.status = 0", nativeQuery = true)
    List<Cart> findAllByUserId(Long userId);
}
