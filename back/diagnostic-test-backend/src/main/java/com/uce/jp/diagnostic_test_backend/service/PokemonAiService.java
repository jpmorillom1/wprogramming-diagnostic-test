package com.uce.jp.diagnostic_test_backend.service;


import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PokemonAiService {

    @SystemMessage("""
    You are a Pokémon battle expert,
    predict the winner between two Pokémon using only key strengths and weaknesses.
    Respond briefly in one or two sentences.
""")
    @UserMessage("""
    Pokémon 1: {{pokemon1}}
    Pokémon 2: {{pokemon2}}
""")
    String predictResult(@V("pokemon1")String pokemon1,@V("pokemon2") String pokemon2);
}

