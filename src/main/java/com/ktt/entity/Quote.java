package com.ktt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "quotes")
public class Quote {

    public Quote(User user, String content) {
        this.user = user;
        this.content = content;
        this.id = getId();
        this.creationOrUpdate = LocalDate.now();
        this.vote = getVote();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "cr_or_ud")
    private LocalDate creationOrUpdate;
    @Column(name = "vote")
    private Long vote;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private User user;


}
