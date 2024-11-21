package com.example.pokemonapi.move;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoveConfig {

    @Bean
    CommandLineRunner moveCommandLineRunner(
            MoveRepository repository) {
        return args -> {
        };
    }
}
