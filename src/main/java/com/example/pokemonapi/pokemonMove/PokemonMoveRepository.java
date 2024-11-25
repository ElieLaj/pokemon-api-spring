package com.example.pokemonapi.pokemonMove;

import com.example.pokemonapi.move.Move;
import com.example.pokemonapi.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonMoveRepository extends JpaRepository<PokemonMove, Long> {

    List<PokemonMove> findPokemonMovesByPokemonId(Long pokemonId);
    Optional<PokemonMove> findPokemonMovesByMove_NameAndPokemon_Name(String moveName, String pokemonName);
}
