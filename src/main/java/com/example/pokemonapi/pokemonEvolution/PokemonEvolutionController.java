package com.example.pokemonapi.pokemonEvolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/pokemon_evolution")
public class PokemonEvolutionController {

    private final PokemonEvolutionService pokemonEvolutionService;

    @Autowired
    public PokemonEvolutionController(PokemonEvolutionService pokemonEvolutionService) {
        this.pokemonEvolutionService = pokemonEvolutionService;
    }

    @PostMapping
    public PokemonEvolution addEvolution(
            @RequestBody PokemonEvolutionDTO dto
            ) {
        return this.pokemonEvolutionService.addEvolution(dto);
    }



    @GetMapping
    public List<PokemonEvolution> findAllEvolutions() {
        return this.pokemonEvolutionService.findAllEvolutions();
    }
}
