package com.ktt.service;

import com.ktt.entity.Quote;
import com.ktt.entity.User;
import com.ktt.repository.QuoteRepository;
import com.ktt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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
    public void createQuote(User user, String content) {
        Quote newQuote = new Quote(user, content);
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

    @Override
    public Quote getRndmQuote() {
        List<Quote> allQuotes = quoteRepository.getAllBy();
        Random randomizer = new Random();
        Quote rndmQuote = allQuotes.get(randomizer.nextInt(allQuotes.size()));
        return rndmQuote;
    }
}
