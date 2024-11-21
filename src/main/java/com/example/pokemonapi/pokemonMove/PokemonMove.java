package com.example.pokemonapi.pokemonMove;

import com.example.pokemonapi.move.Move;
import com.example.pokemonapi.pokemon.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "pokemon_move")
public class PokemonMove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", referencedColumnName = "id")
    @JsonIgnoreProperties("pokemonMoves")
    private Pokemon pokemon;

    @ManyToOne
    @JoinColumn(name = "move_id", referencedColumnName = "id")
    @JsonIgnoreProperties("pokemonMoves")
    private Move move;

    private int level;

    public PokemonMove() {
    }

    public PokemonMove(Pokemon pokemon, Move move, int level) {
        super();
        this.pokemon = pokemon;
        this.move = move;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
