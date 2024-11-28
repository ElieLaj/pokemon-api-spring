package com.example.pokemonapi.stagePokemon;

import com.example.pokemonapi.pokemon.Pokemon;
import com.example.pokemonapi.pokemon.PokemonRepository;
import com.example.pokemonapi.pokemonMove.PokemonMove;
import com.example.pokemonapi.stage.Stage;
import com.example.pokemonapi.stage.StageRepository;
import org.springframework.stereotype.Service;

@Service
public class StagePokemonService {

        private final PokemonRepository pokemonRepository;
        private final StageRepository stageRepository;

        public StagePokemonService(PokemonRepository pokemonRepository, StageRepository stageRepository) {
            this.pokemonRepository = pokemonRepository;
            this.stageRepository = stageRepository;
        }

        public Stage addPokemonToStage(Long stageId, Long pokemonId) {
            Stage stage = (
                    stageRepository.findById(stageId)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Stage with id " + stageId + " not found")
                            )
            );
            Pokemon pokemon = (
                    pokemonRepository.findById(pokemonId)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Pokemon with id " + pokemonId + " not found")
                            )
            );

            stage.addPokemon(pokemon);
            stageRepository.save(stage);
            return stage;
        }

    public Stage removePokemonFromStage(Long stageId, Long pokemonId) {
        Stage stage = stageRepository.findById(stageId)
                .orElseThrow(() -> new IllegalStateException("Stage with id " + stageId + " not found"));
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new IllegalStateException("Pokemon with id " + pokemonId + " not found"));

        stage.removePokemon(pokemon);
        stageRepository.save(stage);
        return stage;
    }

}
