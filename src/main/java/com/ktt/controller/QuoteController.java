package com.ktt.controller;

import com.ktt.entity.Quote;
import com.ktt.entity.User;
import com.ktt.service.QuoteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuoteController {
    private final QuoteServiceImpl quoteService;

    public QuoteController(QuoteServiceImpl quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/allQuotes")
    List<Quote> all() {
        return quoteService.getAllQuotes();
    }

    @GetMapping("/top10")
    List<Quote> getTop10() {
        return quoteService.getTop10();
    }

    @GetMapping("/flop10")
    List<Quote> getFlop10() {
        return quoteService.getFlop10();
    }

    @GetMapping("/allQuotes/rndm")
    Quote getRndmQuote() {
        return quoteService.getRndmQuote();
    }

    @PostMapping("/profile")
    void createQuote(User user, String content) {
        quoteService.createQuote(user, content);
    }

    @PutMapping("/profile")
    void updateQuote(Quote quote, String changes) {
        quoteService.updateQuote(quote, changes);
    }

    @DeleteMapping("/profile")
    void delete(String email, Quote quote) {
        quoteService.delete(email, quote);
    }

    @PostMapping("/allQuotes/up")
    void upVote(Quote quote) {
        quoteService.upVote(quote);
    }

    @PostMapping("/allQuotes/down")
    void downVote(Quote quote) {
        quoteService.downVote(quote);
    }




}

