package com.ktt.service;

import com.ktt.entity.Quote;

import java.util.List;


public interface QuoteService {

    List<Quote> getAllQuotes();

    void createQuote(String email, String content);

    void updateQuote(Quote quote, String changes);

    void delete(String email, Quote quote);

    void upVote(Quote quote);

    void downVote(Quote quote);

    List<Quote> getTop10();

    List<Quote> getFlop10();

}
