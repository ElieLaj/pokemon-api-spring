package com.example.pokemonapi.healingItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HealingItemRepository extends JpaRepository<HealingItem, Long> {

}
