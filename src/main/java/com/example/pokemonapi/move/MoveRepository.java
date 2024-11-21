package com.example.pokemonapi.move;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {

    Optional<Move> findMoveByName(String name);

    Move findMoveById(Long id);
}
