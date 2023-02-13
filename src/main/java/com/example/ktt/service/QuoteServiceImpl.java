package com.example.ktt.service;

import com.example.ktt.entity.Quote;
import com.example.ktt.repository.QuoteRepository;
import com.example.ktt.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final UserRepository userRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository, UserRepository userRepository) {
        this.quoteRepository = quoteRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.getAllBy();
    }

    @Override
    public void createQuote(String email, String content) {
        Quote newQuote = new Quote();
        newQuote.setUser(userRepository.getUserByEmail(email));
        newQuote.setContent(content);
        newQuote.setCreationOrUpdate(LocalDate.now());
        quoteRepository.save(newQuote);
    }

    @Override
    public void updateQuote(Quote quote, String changes) {
        quote.setContent(changes);
        quoteRepository.save(quote);
    }

    @Override
    public void delete(String email, Quote quote) {
        List<Quote> quotesByUser = quoteRepository.getAllByUser(userRepository.getUserByEmail(email));
        Optional<Quote> oldQuote = quotesByUser.stream().filter(x -> x.equals(quote)).findFirst();
        if (oldQuote.isPresent()) {
            quoteRepository.delete(quote);
        }
    }

    @Override
    public void vote(Quote quote, String email, Long vote) {
        

    }
}
