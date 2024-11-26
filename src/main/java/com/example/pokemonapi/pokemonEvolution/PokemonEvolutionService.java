package com.example.pokemonapi.pokemonEvolution;

import com.example.pokemonapi.pokemon.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonEvolutionService {
    private final PokemonEvolutionRepository pokemonEvolutionRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonEvolutionService(PokemonEvolutionRepository pokemonEvolutionRepository, PokemonRepository pokemonRepository){
        this.pokemonEvolutionRepository = pokemonEvolutionRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonEvolution addEvolution(PokemonEvolutionDTO dto){
        PokemonEvolution pokemonEvolution = new PokemonEvolution();

        if (dto.getToPokemon().equals(dto.getFromPokemon())){
            throw new IllegalStateException("Base and evolution pokemon cannot be the same");
        }

        pokemonEvolution.setToPokemon(this.pokemonRepository.findById(dto.getToPokemon()).orElseThrow(
                () -> new IllegalStateException("Evolution pokemon not found")
        ));

        pokemonEvolution.setFromPokemon(this.pokemonRepository.findById(dto.getFromPokemon()).orElseThrow(
                () -> new IllegalStateException("Base pokemon not found")
        ));

        pokemonEvolution.setLevelRequired(dto.getLevel());

        return this.pokemonEvolutionRepository.save(pokemonEvolution);
    }

    public List<PokemonEvolution> findAllEvolutions(){
        return this.pokemonEvolutionRepository.findAll();
    }

}
