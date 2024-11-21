package com.example.pokemonapi.move;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Move createMove(@RequestBody Move newMove) {
        return moveService.createMove(newMove);
    }

    @PutMapping(path = "{moveId}")
    public Move updateMove(
            @PathVariable("moveId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer power,
            @RequestParam(required = false) Integer accuracy,
            @RequestParam(required = false) Long typeId){
        return moveService.updateMove(id, name, power, accuracy, typeId);
    }
}
