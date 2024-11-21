package com.example.pokemonapi.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    // @Query("SELECT p FROM Pokemon p WHERE p.name = ?1")
    Optional<Pokemon> findPokemonByName(String name);
    Optional<Pokemon> findPokemonById(Long id);
}
