package com.ktt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "quotes")
public class Quote {
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
