package com.example.pokemonapi.move;

import com.example.pokemonapi.type.Type;
import com.example.pokemonapi.type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {
    private final MoveRepository moveRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public MoveService(MoveRepository moveRepository, TypeRepository typeRepository) {
        this.moveRepository = moveRepository;
        this.typeRepository = typeRepository;
    }

    public List<Move> getMoves() {
        return moveRepository.findAll();
    }

    public Move createMove(Move newMove, Long typeId, String typeName) {
        moveRepository.findMoveByName(newMove.getName()).ifPresent(move -> {
            throw new IllegalStateException
                    ("Move with name " + newMove.getName() + " already exists");
        });

        if (typeId != null && typeId > 0) {
            Type type = (
                    typeRepository.findById(typeId)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with id " + typeId + " not found")
                            )
            );
            newMove.setType(type);
        }

        if (typeName != null) {
            Type type = (
                    typeRepository.findTypeByName(typeName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with name " + typeName + " not found")
                            )
            );
            newMove.setType(type);
        }

        return moveRepository.save(newMove);
    }

    public Move updateMove(Long id, String name, Integer power, Integer accuracy, Long typeId, String typeName) {
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

        return moveRepository.save(move);
    }
}
