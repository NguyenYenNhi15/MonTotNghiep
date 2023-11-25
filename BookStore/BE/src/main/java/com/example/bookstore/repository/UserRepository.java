package com.example.bookstore.repository;

import com.example.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    //    @Query(value = "SELECT * FROM user u WHERE u.username = :username", nativeQuery = true)
//    User findByUsername(String username);
    @Query(value = "SELECT * FROM \"user\" u WHERE u.username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);

    @Query(value = "INSERT INTO \"user\" (id,name, phone_number, email, address, username, password) " +
            "VALUES (:#{#u.id},:#{#u.name}, :#{#u.phoneNumber}, :#{#u.email}, :#{#u.address}, :#{#u.username}, :#{#u.password}) " +
            "RETURNING *", nativeQuery = true)
    User saveUser(@Param("u") User u);
}
