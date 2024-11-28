package com.example.pokemonapi.stage;

import com.example.pokemonapi.pokemon.Pokemon;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long minLevel;

    @ManyToMany(mappedBy = "stages")
    private List<Pokemon> pokemons = new ArrayList<>();

    public Stage() {
    }

    public Stage(String name, Long minLevel) {
        super();
        this.name = name;
        this.minLevel = minLevel;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        if (!this.pokemons.contains(pokemon)) {
            this.pokemons.add(pokemon);
            pokemon.addStage(this);
        }
    }

    public void removePokemon(Pokemon pokemon) {
        if (this.pokemons.contains(pokemon)) {
            this.pokemons.remove(pokemon);
            pokemon.removeStage(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Long minLevel) {
        this.minLevel = minLevel;
    }
}
