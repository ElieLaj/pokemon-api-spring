package com.example.pokemonapi.pokemon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PokemonConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            PokemonRepository repository) {
                return args -> {
                };
            }
}
