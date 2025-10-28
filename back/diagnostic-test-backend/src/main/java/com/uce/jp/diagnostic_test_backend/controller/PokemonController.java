package com.uce.jp.diagnostic_test_backend.controller;

import com.uce.jp.diagnostic_test_backend.controller.service.PokemonService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping("/pokemon/{id}")
    ResponseEntity<?> getPokemon(@PathVariable Long id){

        Object pokemon= pokemonService.getPokemon(id);









        return ResponseEntity.ok(pokemon);
    }
}
