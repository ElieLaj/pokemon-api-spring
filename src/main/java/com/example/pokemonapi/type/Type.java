package com.example.pokemonapi.type;

import com.example.pokemonapi.move.Move;
import com.example.pokemonapi.pokemon.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type")
public class Type {
    @Id
            @SequenceGenerator(
                    name = "type_sequence",
                    sequenceName = "type_sequence",
                    allocationSize = 1
            )
            @GeneratedValue(
                    strategy = GenerationType.SEQUENCE,
                    generator = "type_sequence"
            )
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "types")
    @JsonIgnoreProperties("types")
    private List<Pokemon> pokemons = new ArrayList<>();


    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("type")
    private List<Move> moves = new ArrayList<>();

    public Type() {
    }

    public Type(String name) {
        super();
        this.name = name;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
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
}
