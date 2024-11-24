package com.example.pokemonapi.stagePokemon;

public class PokemonStageDTO {
    private Long pokemonId;
    private Long stageId;

    public PokemonStageDTO(Long pokemonId, Long stageId) {
        this.pokemonId = pokemonId;
        this.stageId = stageId;
    }

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
}
