package com.uce.jp.diagnostic_test_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "search_history")
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pokemonName;
    private LocalDateTime searchDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public SearchHistory(){}

    public SearchHistory(Long id, String pokemonName, LocalDateTime searchDate, User user) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.searchDate = searchDate;
        this.user = user;
    }

    public SearchHistory(String pokemonName, User user) {
        this.pokemonName = pokemonName;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public LocalDateTime getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(LocalDateTime searchDate) {
        this.searchDate = searchDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}