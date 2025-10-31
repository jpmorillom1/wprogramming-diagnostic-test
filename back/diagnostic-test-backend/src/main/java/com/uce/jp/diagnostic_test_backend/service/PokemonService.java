package com.uce.jp.diagnostic_test_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokemonService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PokemonAiService aiService;


    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/{id}";

    public Map<String,Object> getPokemon(Long id) {
      //  Object response = restTemplate.getForObject(POKE_API_URL, Object.class, id);
        Map response = restTemplate.getForObject(POKE_API_URL,Map.class,id);

        HashMap<String,Object> pokemon= new HashMap<>();

        if (response!=null){
            pokemon.put("name",response.get("name"));

            List<HashMap<String,Object>> typesList=   (List<HashMap<String,Object>>)(response.get("types"));
            List<String> types = new ArrayList<>();
            for (int i = 0; i < typesList.size(); i++) {
                HashMap<String,Object> tp= typesList.get(i);
                HashMap<String,Object> typeInfo= (HashMap<String, Object>) tp.get("type");
                String typeName= (String) typeInfo.get("name");
                types.add(typeName);
            }
            pokemon.put("types",types);

            Map<String,Object> mapSprites= (HashMap<String,Object>) response.get("sprites");
            Map<String,Object> mapOtherSprites = (HashMap<String,Object>) mapSprites.get("other");
            Map<String,Object> mapHomeSprites = (HashMap<String,Object>) mapOtherSprites.get("home");
            String spriteUrl= (String) mapHomeSprites.get("front_default");
            pokemon.put("sprite",spriteUrl);

            System.out.println(types    );
           // System.out.println(response.get("sprites"));
        }
        System.out.println(pokemon);
        return pokemon;
    }




    public String generatePrediction (String pokemon1,String pokemon2){

        return aiService.predictResult(pokemon1,pokemon2);

    }
}

