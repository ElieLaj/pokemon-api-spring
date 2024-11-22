package com.example.pokemonapi.moveEffect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveEffectRepository extends JpaRepository<MoveEffect, Long> {
    MoveEffect findMoveEffectById(Long id);
}
