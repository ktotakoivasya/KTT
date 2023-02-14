package com.ktt.repository;

import com.ktt.entity.Quote;
import com.ktt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> getAllBy();

    // method "save" & "delete" & "getById" are in JpaRepository

    List<Quote> getAllByUser(User user);


}
