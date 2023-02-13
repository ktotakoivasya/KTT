package com.example.ktt.repository;

import com.example.ktt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User getUserByEmail(String email);
}
