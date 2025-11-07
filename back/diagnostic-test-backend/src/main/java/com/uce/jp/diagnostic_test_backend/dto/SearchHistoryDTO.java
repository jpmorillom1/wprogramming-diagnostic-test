package com.uce.jp.diagnostic_test_backend.dto;

import java.time.LocalDateTime;

public record SearchHistoryDTO(Long id, String pokemonName, LocalDateTime searchDate) {
}
