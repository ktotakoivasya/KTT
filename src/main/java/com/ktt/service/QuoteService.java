package com.ktt.service;

import com.ktt.entity.Quote;
import com.ktt.entity.User;

import java.util.List;


public interface QuoteService {

    List<Quote> getAllQuotes();

    void createQuote(User user, String content);

    void updateQuote(Quote quote, String changes);

    void delete(String email, Quote quote);

    void upVote(Quote quote);

    void downVote(Quote quote);

    List<Quote> getTop10();

    List<Quote> getFlop10();

    Quote getRndmQuote();

}
