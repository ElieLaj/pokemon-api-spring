package com.example.pokemonapi.healingItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealingItemRepository extends JpaRepository<HealingItem, Long> {

}
