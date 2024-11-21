package com.example.pokemonapi.pokemonMove;

import com.example.pokemonapi.move.MoveRepository;
import com.example.pokemonapi.pokemon.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonMoveService {

    private final PokemonMoveRepository pokemonMoveRepository;
    private final PokemonRepository pokemonRepository;
    private final MoveRepository moveRepository;

    @Autowired
    public PokemonMoveService(PokemonMoveRepository pokemonMoveRepository, PokemonRepository pokemonRepository, MoveRepository moveRepository) {
        this.pokemonMoveRepository = pokemonMoveRepository;
        this.pokemonRepository = pokemonRepository;
        this.moveRepository = moveRepository;
    }

    public List<PokemonMove> getPokemonMoves() {
        return pokemonMoveRepository.findAll();
    }

    public PokemonMove createPokemonMove(Long pokemonId, Long moveId) {
        PokemonMove pokemonMove = new PokemonMove();
        pokemonMove.setPokemon(pokemonRepository.findPokemonById(pokemonId).orElseThrow());
        pokemonMove.setMove(moveRepository.findMoveById(moveId));
        return pokemonMoveRepository.save(pokemonMove);
    }

    public List<PokemonMove> getPokemonMovesByPokemonId(Long pokemonId) {
        return pokemonMoveRepository.findPokemonMovesByPokemonId(pokemonId);
    }

    public void deletePokemonMove(Long pokemonMoveId) {
        boolean exists = pokemonMoveRepository.existsById(pokemonMoveId);
        if (!exists) throw new IllegalStateException("PokemonMove with id " + pokemonMoveId + " not found");
        pokemonMoveRepository.deleteById(pokemonMoveId);
    }
}
