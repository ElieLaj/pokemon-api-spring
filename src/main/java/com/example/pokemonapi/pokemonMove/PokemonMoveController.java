package com.example.pokemonapi.pokemonMove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pokemon_move")
@CrossOrigin
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

        @PostMapping
        public PokemonMove createPokemonMove(
                @RequestBody PokemonMoveDTO newPokemonMoveDTO
                ) {
            return pokemonMoveService.createPokemonMove(newPokemonMoveDTO);
        }

        @PostMapping("bulk")
        public List<PokemonMove> createPokemonMoves(
                @RequestBody List<PokemonMoveDTO> newPokemonMovesDTO) {

            return pokemonMoveService.createPokemonMoves(newPokemonMovesDTO);
        }
}
