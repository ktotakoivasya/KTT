package com.example.ktt.repository;

import com.example.ktt.entity.Quote;
import com.example.ktt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> getAllBy();

    // method "save" & "delete" & "getById" are in JpaRepository

    List<Quote> getAllByUser(User user);


}
