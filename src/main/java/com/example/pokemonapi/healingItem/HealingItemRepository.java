package com.example.pokemonapi.healingItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface HealingItemRepository extends JpaRepository<HealingItem, Long> {
    Optional<HealingItem> findHealingItemByName(String name);

    HealingItem findHealingItemById(Long id);
}
