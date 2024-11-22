package com.example.pokemonapi.moveEffect;

import com.example.pokemonapi.effect.EffectRepository;
import com.example.pokemonapi.move.MoveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveEffectService {

    private final MoveEffectRepository moveEffectRepository;
    private final EffectRepository effectRepository;
    private final MoveRepository moveRepository;

    public MoveEffectService(MoveEffectRepository moveEffectRepository, EffectRepository effectRepository, MoveRepository moveRepository) {
        this.moveEffectRepository = moveEffectRepository;
        this.effectRepository = effectRepository;
        this.moveRepository = moveRepository;
    }

    public MoveEffect addMoveEffect(MoveEffectDTO dto) {
        MoveEffect moveEffect = new MoveEffect();

        moveEffect.setOdds(dto.getOdds());
        moveEffect.setEffect(effectRepository.findEffectByName(dto.getEffect()).orElseThrow(() -> new IllegalStateException("Effect with name " + dto.getEffect() + " not found")));
        moveEffect.setMove(moveRepository.findMoveByName(dto.getMove()).orElseThrow(() -> new IllegalStateException("Move with name " + dto.getMove() + " not found")));

        return moveEffectRepository.save(moveEffect);
    }

    public List<MoveEffect> getMoveEffects() {
        return moveEffectRepository.findAll();
    }

    public MoveEffect getMoveEffectById(Long id) {
        return moveEffectRepository.findMoveEffectById(id);
    }

    public void deleteMoveEffect(Long id) {
        moveEffectRepository.deleteById(id);
    }

    public MoveEffect updateMoveEffect(Long id, MoveEffect moveEffect) {
        MoveEffect moveEffectToUpdate = moveEffectRepository.findMoveEffectById(id);
        moveEffectToUpdate.setOdds(moveEffect.getOdds());
        return moveEffectRepository.save(moveEffectToUpdate);
    }
}
