package com.example.ktt.service;

import com.example.ktt.entity.Quote;
import com.example.ktt.entity.User;

import java.util.List;

public interface QuoteService {

    List<Quote> getAllQuotes();

    void createQuote(String email, String content);

    void updateQuote(Quote quote, String changes);

    void delete(String email, Quote quote);

    void vote(Quote quote, String email, Long vote);

}
