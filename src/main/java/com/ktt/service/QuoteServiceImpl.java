package com.ktt.service;

import com.ktt.entity.Quote;
import com.ktt.repository.QuoteRepository;
import com.ktt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private final QuoteRepository quoteRepository;
    @Autowired
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
    public void upVote(Quote quote) {
        quote.setVote((long)+1);
        quoteRepository.save(quote);
    }

    @Override
    public void downVote(Quote quote) {
        quote.setVote((long)-1);
        quoteRepository.save(quote);
    }

    @Override
    public List<Quote> getTop10() {
        List<Quote> allQuotes = new ArrayList<>(quoteRepository.getAllBy());
        allQuotes.sort(Comparator.comparingLong(Quote::getVote));
        List<Quote> top10 = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            top10.add(allQuotes.get(i));
        }
        return top10;
    }

    @Override
    public List<Quote> getFlop10() {
        List<Quote> allQuotes = new ArrayList<>(quoteRepository.getAllBy());
        allQuotes.sort(Comparator.comparingLong(Quote::getVote));
        List<Quote> flop10 = new ArrayList<>();
        for(int i = allQuotes.size()-1; i > allQuotes.size()-11; i--) {
            flop10.add(allQuotes.get(i));
        }
        return flop10;
    }
}
