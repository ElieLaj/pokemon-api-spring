package com.example.pokemonapi.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping
    public Pokemon createPokemon(
            @RequestBody Pokemon newPokemon,
            @RequestParam(required = false) Long typeId,
            @RequestParam(required = false) String typeName,
            @RequestParam(required = false) Long typeId2,
            @RequestParam(required = false) String typeName2
    ) {
        return pokemonService.createPokemon(newPokemon, typeId, typeName, typeId2, typeName2);
    }

    @GetMapping
    public List<Pokemon> getPokemon() {
        return pokemonService.getPokemons();
    }

    @GetMapping(path = "{pokemonId}")
    public Pokemon getPokemon(@PathVariable("pokemonId") Long pokemonId) {
        return pokemonService.getPokemon(pokemonId);
    }

    @DeleteMapping(path = "{pokemonId}")
    public void deletePokemon(@PathVariable("pokemonId") Long pokemonId) {
        pokemonService.deletePokemon(pokemonId);
    }

    @PutMapping(path = "{pokemonId}")
    public Pokemon updatePokemon(
            @PathVariable("pokemonId") Long pokemonId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer hp,
            @RequestParam(required = false) Integer attack,
            @RequestParam(required = false) Integer defense,
            @RequestParam(required = false) Integer specialAttack,
            @RequestParam(required = false) Integer specialDefense,
            @RequestParam(required = false) Integer speed,
            @RequestParam(required = false) Integer expRate,
            @RequestParam(required = false) Long typeId,
            @RequestParam(required = false) String typeName
    ) {
        return pokemonService.updatePokemon(pokemonId, name, hp, attack, defense, specialAttack, specialDefense, speed, expRate, typeId, typeName);
    }

    @PutMapping(path = "{pokemonId}/reset_type")
    public Pokemon resetType(@PathVariable("pokemonId") Long pokemonId) {
        return pokemonService.resetType(pokemonId);
    }

}
