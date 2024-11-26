package com.example.pokemonapi.pokemonEvolution;

import com.example.pokemonapi.pokemon.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Table
@Entity
public class PokemonEvolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_pokemon_id")
    @JsonIgnoreProperties({"evolutions", "fromPokemon"})
    private Pokemon fromPokemon;

    @ManyToOne
    @JsonIgnoreProperties({"evolutions", "toPokemon"})
    @JoinColumn(name = "to_pokemon_id")
    private Pokemon toPokemon;

    private int levelRequired;

    public PokemonEvolution(){}

    public PokemonEvolution(Pokemon fromPokemon, Pokemon toPokemon, int levelRequired){
        this.fromPokemon = fromPokemon;
        this.toPokemon = toPokemon;
        this.levelRequired = levelRequired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pokemon getFromPokemon() {
        return fromPokemon;
    }

    public void setFromPokemon(Pokemon fromPokemon) {
        this.fromPokemon = fromPokemon;
    }

    public Pokemon getToPokemon() {
        return toPokemon;
    }

    public void setToPokemon(Pokemon toPokemon) {
        this.toPokemon = toPokemon;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(int levelRequired) {
        this.levelRequired = levelRequired;
    }
}
