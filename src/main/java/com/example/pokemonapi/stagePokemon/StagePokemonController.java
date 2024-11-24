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


            @PostMapping(path = "")
            public Stage addPokemonToStage(
                    @RequestBody PokemonStageDTO pokemonStageDTO)
            {
                return stagePokemonService.addPokemonToStage(pokemonStageDTO.getStageId(), pokemonStageDTO.getPokemonId());
            }



            @DeleteMapping(path = "{stageId}/{pokemonId}")
            public void deleteStagePokemon(
                    @PathVariable Long stageId,
                    @PathVariable Long pokemonId )
            {
                stagePokemonService.removePokemonFromStage(stageId, pokemonId);
            }
}
