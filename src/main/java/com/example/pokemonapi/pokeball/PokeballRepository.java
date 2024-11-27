package com.example.pokemonapi.pokeball;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokeballRepository extends JpaRepository<Pokeball, Long> {
}
