package com.example.pokemonapi.stagePokemon;

import com.example.pokemonapi.stage.Stage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stage_pokemon")
@CrossOrigin
public class StagePokemonController {

            private final StagePokemonService stagePokemonService;

            public StagePokemonController(StagePokemonService stagePokemonService) {
                this.stagePokemonService = stagePokemonService;
            }

            @PostMapping(path = "{stageId}/{pokemonId}")
            public Stage addPokemonToStage(
                    @PathVariable Long stageId,
                    @PathVariable Long pokemonId ) {
                return stagePokemonService.addPokemonToStage(stageId, pokemonId);
            }



            @DeleteMapping(path = "{stageId}/{pokemonId}")
            public void deleteStagePokemon(
                    @PathVariable Long stageId,
                    @PathVariable Long pokemonId )
            {
                stagePokemonService.removePokemonFromStage(stageId, pokemonId);
            }
}
