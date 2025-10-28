package com.uce.jp.diagnostic_test_backend.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PokemonService {

    @Autowired
    private RestTemplate restTemplate;


    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/{id}";

    public Object getPokemon(Long id) {
        Object response = restTemplate.getForObject(POKE_API_URL, Object.class, id);
        return response;
    }
}
