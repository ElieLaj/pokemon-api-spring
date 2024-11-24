package com.example.pokemonapi.effect;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EffectService {

    private final EffectRepository effectRepository;

    public EffectService(EffectRepository effectRepository) {
        this.effectRepository = effectRepository;
    }

    public Effect addEffect(Effect effect) {
        return effectRepository.save(effect);
    }

    public List<Effect> getEffects() {
        return effectRepository.findAll();
    }

    public void deleteEffect(Long effectId) {
        boolean exists = effectRepository.existsById(effectId);
        if (!exists) {
            throw new IllegalStateException("Effect with id " + effectId + " does not exist");
        }
        effectRepository.deleteById(effectId);
    }

    public Effect getEffect(Long id) {
        return effectRepository.findById(id).orElseThrow(() -> new IllegalStateException("Effect with id " + id + " not found"));
    }

    public Effect createEffect(Effect newEffect) {
        effectRepository.findEffectByName(newEffect.getName()).ifPresent(effect -> {
            throw new IllegalStateException("Effect with name " + newEffect.getName() + " already exists");
        });
        return effectRepository.save(newEffect);
    }

    public List<Effect> createEffects(List<Effect> newEffects) {
        for (Effect newEffect : newEffects) {
            effectRepository.findEffectByName(newEffect.getName()).ifPresent(effect -> {
                throw new IllegalStateException("Effect with name " + newEffect.getName() + " already exists");
            });
        }
        return effectRepository.saveAll(newEffects);
    }

    public Effect updateEffect(Long id, Effect updatedEffect) {
        Effect effect = effectRepository.findById(id).orElseThrow(() -> new IllegalStateException("Effect with id " + id + " not found"));
        effect.setName(updatedEffect.getName());
        effect.setTurns(updatedEffect.getTurns());
        effect.setDamage(updatedEffect.getDamage());
        return effectRepository.save(effect);
    }
}
