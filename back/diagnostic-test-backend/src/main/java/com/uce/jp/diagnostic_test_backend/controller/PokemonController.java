package com.uce.jp.diagnostic_test_backend.controller;

import com.uce.jp.diagnostic_test_backend.service.PokemonService;
import com.uce.jp.diagnostic_test_backend.service.SearchHistoryService;
import com.uce.jp.diagnostic_test_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private UserService userService;
    @Autowired
    private SearchHistoryService searchHistoryService;


    @GetMapping("/pokemon/{id}")
    ResponseEntity<?> getPokemon(@PathVariable Long id){

        Map<String,Object> pokemon= pokemonService.getPokemon(id);
        return ResponseEntity.ok(pokemon);
    }

    @GetMapping("/pokemon/predict/{pokemon1}/{pokemon2}")
    ResponseEntity<?> getPrediction (@PathVariable String pokemon1,@PathVariable String pokemon2){

        Map<String,String> predictionMap=new HashMap<>();
        predictionMap.put("prediction", pokemonService.generatePrediction(pokemon1,pokemon2));
        return ResponseEntity.ok(predictionMap);

    }
}
