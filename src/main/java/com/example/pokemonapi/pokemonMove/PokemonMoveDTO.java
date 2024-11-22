package com.example.pokemonapi.pokemonMove;

public class PokemonMoveDTO
{

    private String moveName;
    private String pokemonName;
    private int level;

    public PokemonMoveDTO(String moveName, String pokemonName, int level) {
        this.moveName = moveName;
        this.pokemonName = pokemonName;
        this.level = level;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
