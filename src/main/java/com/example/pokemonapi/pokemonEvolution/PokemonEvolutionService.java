package com.example.pokemonapi.pokemonEvolution;

import com.example.pokemonapi.pokemon.Pokemon;
import com.example.pokemonapi.pokemon.PokemonRepository;
import com.example.pokemonapi.pokemonMove.PokemonMove;
import com.example.pokemonapi.pokemonMove.PokemonMoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonEvolutionService {
    private final PokemonEvolutionRepository pokemonEvolutionRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonMoveRepository pokemonMoveRepository;

    @Autowired
    public PokemonEvolutionService(PokemonEvolutionRepository pokemonEvolutionRepository, PokemonRepository pokemonRepository, PokemonMoveRepository pokemonMoveRepository) {
        this.pokemonEvolutionRepository = pokemonEvolutionRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokemonMoveRepository = pokemonMoveRepository;
    }

    public PokemonEvolution addEvolution(PokemonEvolutionDTO dto){
        PokemonEvolution pokemonEvolution = new PokemonEvolution();

        if (dto.getToPokemon().equals(dto.getFromPokemon())){
            throw new IllegalStateException("Base and evolution pokemon cannot be the same");
        }

        pokemonEvolution.setToPokemon(this.pokemonRepository.findById(dto.getToPokemon()).orElseThrow(
                () -> new IllegalStateException("Evolution pokemon not found")
        ));

        Pokemon base = this.pokemonRepository.findById(dto.getFromPokemon()).orElseThrow(
                () -> new IllegalStateException("Evolution pokemon not found")
        );


        for(PokemonMove move : base.getPokemonMoves()){
            PokemonMove pokemonMove = new PokemonMove();
            pokemonMove.setPokemon(pokemonRepository.findById(dto.getFromPokemon()).orElseThrow());
            pokemonMove.setMove(move.getMove());
            pokemonMove.setLevel(move.getLevel());
            this.pokemonMoveRepository.save(pokemonMove);
        }


        pokemonEvolution.setFromPokemon(this.pokemonRepository.findById(dto.getFromPokemon()).orElseThrow(
                () -> new IllegalStateException("Base pokemon not found")
        ));

        pokemonEvolution.setLevelRequired(dto.getLevel());

        return this.pokemonEvolutionRepository.save(pokemonEvolution);
    }

    public List<PokemonEvolution> findAllEvolutions(){
        return this.pokemonEvolutionRepository.findAll();
    }

    public PokemonEvolution updateEvolution(Long id, Integer level) {
        PokemonEvolution pokemonEvolution = this.pokemonEvolutionRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Evolution not found")
        );

        pokemonEvolution.setLevelRequired(level);

        return this.pokemonEvolutionRepository.save(pokemonEvolution);
    }
}
