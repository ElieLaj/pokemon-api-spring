package com.example.pokemonapi.pokemonEvolution;

public class PokemonEvolutionDTO {
    private Long id;
    private Long fromPokemon;
    private Long toPokemon;
    private int level;

    public PokemonEvolutionDTO() {
    }

    public PokemonEvolutionDTO(Long id, Long fromPokemon, Long toPokemon, int level) {
        this.id = id;
        this.fromPokemon = fromPokemon;
        this.toPokemon = toPokemon;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromPokemon() {
        return fromPokemon;
    }

    public void setFromPokemon(Long fromPokemon) {
        this.fromPokemon = fromPokemon;
    }

    public Long getToPokemon() {
        return toPokemon;
    }

    public void setToPokemon(Long toPokemon) {
        this.toPokemon = toPokemon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
