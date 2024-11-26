package com.example.pokemonapi.pokemonEvolution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonEvolutionRepository extends JpaRepository<PokemonEvolution, Long> {

}
