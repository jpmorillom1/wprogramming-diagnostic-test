package com.uce.jp.diagnostic_test_backend.service;


import com.uce.jp.diagnostic_test_backend.dto.SearchHistoryDTO;
import com.uce.jp.diagnostic_test_backend.entity.SearchHistory;
import com.uce.jp.diagnostic_test_backend.entity.User;
import com.uce.jp.diagnostic_test_backend.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchHistoryService {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;
    @Autowired
    private UserService userService;

    public void saveSearch(String pokemonName, User user) {
        SearchHistory searchHistory = new SearchHistory(pokemonName, user);
        searchHistory.setSearchDate(LocalDateTime.now());
        searchHistoryRepository.save(searchHistory);
    }

    public List<SearchHistory> getUserSearchHistory(User user) {
        return searchHistoryRepository.findByUserOrderBySearchDateDesc(user);
    }

    public List<SearchHistoryDTO> getUserSearchHistory(String username) {
        User user = userService.findByName(username);
        List<SearchHistory> history = searchHistoryRepository.findByUserOrderBySearchDateDesc(user);

        return convertToDTO(history);
    }

    private List<SearchHistoryDTO> convertToDTO(List<SearchHistory> history) {
        return history.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SearchHistoryDTO convertToDTO(SearchHistory searchHistory) {
        return new SearchHistoryDTO(
                searchHistory.getId(),
                searchHistory.getPokemonName(),
                searchHistory.getSearchDate()
        );
    }

}