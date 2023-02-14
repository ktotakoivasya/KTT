package com.ktt.controller;

import com.ktt.entity.Quote;
import com.ktt.service.QuoteServiceImpl;
import com.ktt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QuoteController {
    @Autowired
    private QuoteServiceImpl quoteService;
    @Autowired
    private UserServiceImpl userService;

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

    @PostMapping("/profile")
    void createQuote(String email, String content) {
        quoteService.createQuote(email, content);
    }

    @PostMapping("/profile")
    void updateQuote(Quote quote, String changes) {
        quoteService.updateQuote(quote, changes);
    }

    @PostMapping("/profile")
    void delete(String email, Quote quote) {
        quoteService.delete(email, quote);
    }

    @PostMapping("/allQuotes")
    void upVote(Quote quote) {
        quoteService.upVote(quote);
    }

    @PostMapping("/allQuotes")
    void downVote(Quote quote) {
        quoteService.downVote(quote);
    }


}

