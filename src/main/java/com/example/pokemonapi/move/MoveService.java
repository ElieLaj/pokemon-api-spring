package com.example.pokemonapi.move;

import com.example.pokemonapi.category.Category;
import com.example.pokemonapi.category.CategoryRepository;
import com.example.pokemonapi.effect.Effect;
import com.example.pokemonapi.effect.EffectRepository;
import com.example.pokemonapi.moveEffect.MoveEffect;
import com.example.pokemonapi.moveEffect.MoveEffectRepository;
import com.example.pokemonapi.type.Type;
import com.example.pokemonapi.type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MoveService {
    private final MoveRepository moveRepository;
    private final TypeRepository typeRepository;
    private final CategoryRepository categoryRepository;
    private final EffectRepository effectRepository;
    private final MoveEffectRepository moveEffectRepository;

    @Autowired
    public MoveService(MoveRepository moveRepository, TypeRepository typeRepository, CategoryRepository categoryRepository, EffectRepository effectRepository, MoveEffectRepository moveEffectRepository) {
        this.moveRepository = moveRepository;
        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
        this.effectRepository = effectRepository;
        this.moveEffectRepository = moveEffectRepository;
    }

    public List<Move> getMoves() {
        return moveRepository.findAll();
    }

    public Move createMove(Move newMove, String typeName, String categoryName, String effectName, Long odds) {
        moveRepository.findMoveByName(newMove.getName()).ifPresent(move -> {
            throw new IllegalStateException
                    ("Move with name " + newMove.getName() + " already exists");
        });

        if (typeName != null) {
            Type type = (
                    typeRepository.findTypeByName(typeName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with name " + typeName + " not found")
                            )
            );
            newMove.setType(type);
        }

        if (categoryName != null) {
            Category category = (
                    categoryRepository.findCategoryByName(categoryName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Category with name " + categoryName + " not found")
                            )
            );
            newMove.setCategory(category);
        }

        if (effectName != null) {
            Effect effect = (
                    effectRepository.findEffectByName(effectName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Effect with name " + effectName + " not found")
                            )
            );

            MoveEffect moveEffect = new MoveEffect();
            moveEffect.setMove(newMove);
            moveEffect.setEffect(effect);
            moveEffect.setOdds(odds);

            newMove.addMoveEffect(moveEffect);
        }

        return moveRepository.save(newMove);
    }

    public Move updateMove(Long id, String name, Integer power, Integer accuracy, Long typeId, String typeName, String categoryName, String effectName, Long odds) {
        Move move = moveRepository.findById(id).orElseThrow(() -> new IllegalStateException("Move with id " + id + " not found"));

        if (name != null && !name.isEmpty() && !name.equals(move.getName())) {
            move.setName(name);
        }

        if (power != null && power > 0 && !power.equals(move.getPower())) {
            move.setPower(power);
        }

        if (accuracy != null && accuracy > 0 && !accuracy.equals(move.getAccuracy())) {
            move.setAccuracy(accuracy);
        }

        if (typeId != null && typeId > 0 && (move.getType() == null || !typeId.equals(move.getType().getId()) )) {
            Type type = (
                    typeRepository.findById(typeId)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with id " + typeId + " not found")
                            )
            );
            move.setType(type);
        }

        if (typeName != null && (move.getType() == null || !typeName.equals(move.getType().getName()) )) {
            Type type = (
                    typeRepository.findTypeByName(typeName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with name " + typeName + " not found")
                            )
            );
            move.setType(type);
        }

        if (categoryName != null && (move.getCategory() == null || !categoryName.equals(move.getCategory().getName()) )) {
            Category category = (
                    categoryRepository.findCategoryByName(categoryName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Category with name " + categoryName + " not found")
                            )
            );
            move.setCategory(category);
        }

        if (effectName != null) {
            Effect effect = (
                    effectRepository.findEffectByName(effectName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Effect with name " + effectName + " not found")
                            )
            );
            move.deleteMoveEffects();

            MoveEffect moveEffect = new MoveEffect();
            moveEffect.setMove(move);
            moveEffect.setEffect(effect);
            moveEffect.setOdds(odds);
            move.addMoveEffect(moveEffect);

            moveEffectRepository.save(moveEffect);
        }

        return moveRepository.save(move);
    }

    public void deleteMove(Long moveId) {
        boolean exists = moveRepository.existsById(moveId);
        if (!exists) throw new IllegalStateException("Move with id " + moveId + " not found");
        moveRepository.deleteById(moveId);
    }

    public Move patchMove(Long id, MoveDTO dto) {
        Move move = moveRepository.findById(id).orElseThrow(() -> new IllegalStateException("Move with id " + id + " not found"));

        if (dto.getName() != null && !dto.getName().isEmpty() && !dto.getName().equals(move.getName())) {
            move.setName(dto.getName());
        }

        if (dto.getPower() != 0) {
            move.setPower(dto.getPower());
        }

        if (dto.getAccuracy() != 0) {
            move.setAccuracy(dto.getAccuracy());
        }

        if (dto.getTypeName() != null && (move.getType() == null || !dto.getTypeName().equals(move.getType().getName()) )) {
            Type type = (
                    typeRepository.findTypeByName(dto.getTypeName())
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with name " + dto.getTypeName() + " not found")
                            )
            );
            move.setType(type);
        }

        if (dto.getCategory() != null && (move.getCategory() == null || !dto.getCategory().equals(move.getCategory().getName()) )) {
            Category category = (
                    categoryRepository.findCategoryByName(dto.getCategory())
                            .orElseThrow(() -> new IllegalStateException
                                    ("Category with name " + dto.getCategory() + " not found")
                            )
            );
            move.setCategory(category);
        }

        if (dto.getEffect() != null) {
            Effect effect = (
                    effectRepository.findEffectByName(dto.getEffect())
                            .orElseThrow(() -> new IllegalStateException
                                    ("Effect with name " + dto.getEffect() + " not found")
                            )
            );
            move.deleteMoveEffects();

            MoveEffect moveEffect = new MoveEffect();
            moveEffect.setMove(move);
            moveEffect.setEffect(effect);
            moveEffect.setOdds(dto.getOdds());

            move.addMoveEffect(moveEffect);

            moveEffectRepository.save(moveEffect);
        }

        return moveRepository.save(move);
    }
}
