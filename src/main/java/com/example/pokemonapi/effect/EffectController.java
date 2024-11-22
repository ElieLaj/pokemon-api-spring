package com.example.pokemonapi.effect;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/effect")
public class EffectController {

    private final EffectService effectService;

    public EffectController(EffectService effectService) {
        this.effectService = effectService;
    }

    @GetMapping
    public List<Effect> getEffects() {
        return effectService.getEffects();
    }

    @GetMapping(path = "{effectId}")
    public Effect getEffect(
            @PathVariable("effectId") Long id) {
        return effectService.getEffect(id);
    }

    @PostMapping
    public Effect createEffect(@RequestBody Effect newEffect) {
        return effectService.createEffect(newEffect);
    }

    @PostMapping(path = "bulk")
    public List<Effect> createEffects(@RequestBody List<Effect> newEffects) {
        return effectService.createEffects(newEffects);
    }

    @PatchMapping(path = "{effectId}")
    public Effect updateEffect(
            @PathVariable("effectId") Long id,
            @RequestBody Effect updatedEffect) {
        return effectService.updateEffect(id, updatedEffect);
    }

    @DeleteMapping(path = "{effectId}")
    public void deleteEffect(@PathVariable("effectId") Long id) {
        effectService.deleteEffect(id);
    }
}
