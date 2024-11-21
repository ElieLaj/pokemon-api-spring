package com.example.pokemonapi.pokemonMove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pokemon_move")
public class PokemonMoveController {

        private final PokemonMoveService pokemonMoveService;

        @Autowired
        public PokemonMoveController(PokemonMoveService pokemonMoveService) {
            this.pokemonMoveService = pokemonMoveService;
        }

        @GetMapping
        public List<PokemonMove> getPokemonMoves() {
            return pokemonMoveService.getPokemonMoves();
        }

        @DeleteMapping(path = "{pokemonMoveId}")
        public void deletePokemonMove(@PathVariable Long pokemonMoveId) {
            pokemonMoveService.deletePokemonMove(pokemonMoveId);
        }

        @GetMapping(path = "{pokemonId}")
        public List<PokemonMove> getPokemonMovesByPokemonId(@PathVariable Long pokemonId) {
            return pokemonMoveService.getPokemonMovesByPokemonId(pokemonId);
        }

        @PostMapping(path = "{pokemonId}/{moveId}")
        public PokemonMove createPokemonMove
                (@PathVariable Long pokemonId, @PathVariable Long moveId) {
            return pokemonMoveService.createPokemonMove(pokemonId, moveId);
        }
}
