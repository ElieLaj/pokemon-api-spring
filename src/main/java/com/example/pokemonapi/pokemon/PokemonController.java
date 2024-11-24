package com.example.pokemonapi.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            @RequestBody PokemonDTO newPokemonDTO
    ) {
        Pokemon newPokemon = new Pokemon(
                null,
                newPokemonDTO.getName(),
                newPokemonDTO.getHp(),
                newPokemonDTO.getAttack(),
                newPokemonDTO.getDefense(),
                newPokemonDTO.getSpecialAttack(),
                newPokemonDTO.getSpecialDefense(),
                newPokemonDTO.getSpeed(),
                newPokemonDTO.getExpRate(),
                newPokemonDTO.getCatchRate()
        );
        return pokemonService.createPokemon(newPokemon, newPokemonDTO.getTypeName());
    }

    @PostMapping(path = "bulk")
    public List<Pokemon> createPokemons(@RequestBody List<PokemonDTO> newPokemonsDTO) {
        List<Pokemon> pokemons = new ArrayList<>();

        for (PokemonDTO dto : newPokemonsDTO) {
            Pokemon newPokemon = new Pokemon(
                    null,
                    dto.getName(),
                    dto.getHp(),
                    dto.getAttack(),
                    dto.getDefense(),
                    dto.getSpecialAttack(),
                    dto.getSpecialDefense(),
                    dto.getSpeed(),
                    dto.getExpRate(),
                    dto.getCatchRate()
            );

            Pokemon createdPokemon = pokemonService.createPokemon(newPokemon, dto.getTypeName());
            pokemons.add(createdPokemon);
        }

        return pokemons;
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
            @RequestBody PokemonDTO dto) {
        return pokemonService.updatePokemon(pokemonId, dto.getName(), dto.getHp(), dto.getAttack(), dto.getDefense(), dto.getSpecialAttack(), dto.getSpecialDefense(), dto.getSpeed(), dto.getExpRate(), dto.getTypeName(), dto.getCatchRate());
    }


}
