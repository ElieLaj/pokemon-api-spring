package com.example.pokemonapi.move;

import com.example.pokemonapi.pokemon.Pokemon;
import com.example.pokemonapi.pokemon.PokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/move")
public class MoveController {

    private final MoveService moveService;

    @Autowired
    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @GetMapping
    public List<Move> getMoves() {
        return moveService.getMoves();
    }

    @PostMapping
    public Move createMove(
            @RequestBody MoveDTO dto) {
        Move newMove = new Move(
                dto.getName(),
                dto.getPower(),
                dto.getAccuracy()
        );
        return moveService.createMove(newMove, dto.getTypeName());
    }

    @PostMapping(path = "bulk")
    public List<Move> createMoves(@RequestBody List<MoveDTO> newMovesDTO) {
        List<Move> moves = new ArrayList<>();

        for (MoveDTO dto : newMovesDTO) {
            Move newMove = new Move(
                    dto.getName(),
                    dto.getPower(),
                    dto.getAccuracy()
            );

            Move createdMove = moveService.createMove(newMove, dto.getTypeName());
            moves.add(createdMove);
        }

        return moves;
    }

    @PutMapping(path = "{moveId}")
    public Move updateMove(
            @PathVariable("moveId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer power,
            @RequestParam(required = false) Integer accuracy,
            @RequestParam(required = false) Long typeId,
            @RequestParam(required = false) String typeName)
            {
        return moveService.updateMove(id, name, power, accuracy, typeId, typeName);
    }
}
