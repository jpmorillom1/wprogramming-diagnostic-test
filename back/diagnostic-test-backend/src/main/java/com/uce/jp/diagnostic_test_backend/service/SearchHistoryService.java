package com.uce.jp.diagnostic_test_backend.service;


import com.uce.jp.diagnostic_test_backend.entity.SearchHistory;
import com.uce.jp.diagnostic_test_backend.entity.User;
import com.uce.jp.diagnostic_test_backend.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchHistoryService {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    public void saveSearch(String pokemonName, User user) {
        SearchHistory searchHistory = new SearchHistory(pokemonName, user);
        searchHistory.setSearchDate(LocalDateTime.now());
        searchHistoryRepository.save(searchHistory);
    }

    public List<SearchHistory> getUserSearchHistory(User user) {
        return searchHistoryRepository.findByUserOrderBySearchDateDesc(user);
    }
}