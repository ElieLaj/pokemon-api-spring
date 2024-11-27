package com.example.pokemonapi.healingItem;

import com.example.pokemonapi.effect.Effect;
import com.example.pokemonapi.effect.EffectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealingItemService {
    private final HealingItemRepository healingItemRepository;
    private final EffectRepository effectRepository;

    @Autowired
    public HealingItemService(HealingItemRepository healingItemRepository, EffectRepository effectRepository){
        this.healingItemRepository = healingItemRepository;
        this.effectRepository = effectRepository;
    }

    public List<HealingItem> getAll(){
        return healingItemRepository.findAll();
    }

    public HealingItem addHealingItem(HealingItemDTO newItem) {
        Effect effect = null;

        if (newItem.getEffect() != null) {
            effect = effectRepository.findById(newItem.getEffect()).orElseThrow(
                    () -> new IllegalStateException("Couldn't find Effect with id:" + newItem.getEffect())
            );
        }

         HealingItem healingItem = new HealingItem(newItem.getName(), newItem.getDescription(), newItem.getPrice(), newItem.getHealAmount(), effect);

         return healingItemRepository.save(healingItem);
    }

    public HealingItem patchHealingItem(Long healingItemId, HealingItemDTO newItem){
        HealingItem healingItem = healingItemRepository.findById(healingItemId).orElseThrow(
                () -> new IllegalStateException("Couldn't find Healing Item with id:" + newItem.getId())
        );

        healingItem.setStatusHeal(effectRepository.findById(newItem.getEffect()).orElseThrow(
                () -> new IllegalStateException("Couldn't find Effect with id:" + newItem.getEffect())
        ));

        healingItem.setHealAmount(newItem.getHealAmount());

        healingItem.setName(newItem.getName());

        healingItem.setDescription(newItem.getDescription());

        healingItem.setPrice(newItem.getPrice());

        return healingItemRepository.save(healingItem);
    }
}
