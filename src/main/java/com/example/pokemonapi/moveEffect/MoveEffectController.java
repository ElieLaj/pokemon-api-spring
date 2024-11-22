package com.example.pokemonapi.moveEffect;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/move_effect")
public class MoveEffectController {

    private final MoveEffectService moveEffectService;

    public MoveEffectController(MoveEffectService moveEffectService) {
        this.moveEffectService = moveEffectService;
    }

    @GetMapping
    public List<MoveEffect> getMoveEffects() {
        return moveEffectService.getMoveEffects();
    }

    @GetMapping(path = "{moveEffectId}")
    public MoveEffect getMoveEffect(Long moveEffectId) {
        return moveEffectService.getMoveEffectById(moveEffectId);
    }

    @PostMapping
    public MoveEffect createMoveEffect(@RequestBody MoveEffectDTO newMoveEffect) {
        return moveEffectService.addMoveEffect(newMoveEffect);
    }

    @DeleteMapping(path = "{moveEffectId}")
    public void deleteMoveEffect(@PathVariable Long moveEffectId) {
        moveEffectService.deleteMoveEffect(moveEffectId);
    }

    @PutMapping(path = "{moveEffectId}")
    public MoveEffect updateMoveEffect(@PathVariable Long moveEffectId, @RequestBody MoveEffect moveEffect) {
        return moveEffectService.updateMoveEffect(moveEffectId, moveEffect);
    }

}
