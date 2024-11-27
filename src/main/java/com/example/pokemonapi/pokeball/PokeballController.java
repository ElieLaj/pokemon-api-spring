package com.example.pokemonapi.pokeball;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pokeball")
@CrossOrigin
public class PokeballController {

    private final PokeballService pokeballService;

    public PokeballController(PokeballService pokeballService) {
        this.pokeballService = pokeballService;
    }

    @GetMapping
    public List<Pokeball> getPokeballs() {
        return pokeballService.getAll();
    }

    @GetMapping(path = "{pokeballId}")
    public Pokeball getPokeball(Long pokeballId) {
        return pokeballService.getPokeball(pokeballId);
    }

    @PostMapping
    public Pokeball createPokeball(@RequestBody Pokeball newPokeball) {
        return pokeballService.addPokeball(newPokeball);
    }

    @PatchMapping(path = "{pokeballId}")
    public Pokeball updatePokeball(@PathVariable Long pokeballId, @RequestBody Pokeball pokeball) {
        return pokeballService.updatePokeball(pokeballId, pokeball);
    }

}
