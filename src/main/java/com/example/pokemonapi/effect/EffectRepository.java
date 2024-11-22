package com.example.pokemonapi.effect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EffectRepository extends JpaRepository<Effect, Long> {
    Optional<Effect> findEffectByName(String name);
}
