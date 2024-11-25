package com.example.pokemonapi.move;

import com.example.pokemonapi.category.Category;
import com.example.pokemonapi.effect.Effect;
import com.example.pokemonapi.moveEffect.MoveEffect;
import com.example.pokemonapi.type.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import com.example.pokemonapi.pokemonMove.PokemonMove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "move")
public class Move {
    @Id
            @SequenceGenerator(
                    name = "move_sequence",
                    sequenceName = "move_sequence",
                    allocationSize = 1
            )
            @GeneratedValue(
                    strategy = GenerationType.SEQUENCE,
                    generator = "move_sequence"
            )
    Long id;
    String name;
    int power;
    int accuracy;


    @OneToMany(mappedBy = "move", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("move")
    private Set<PokemonMove> pokemonMoves = new HashSet<>();

    @OneToMany(mappedBy = "move", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("move")
    private Set<MoveEffect> moveEffects = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = { "moves", "pokemons" })
    private Category category;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = { "moves", "pokemons" })
    private Type type;


    public Move() {
    }

    public Move(String name, int power, int accuracy) {
        super();
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<PokemonMove> getPokemonMoves() {
        return pokemonMoves;
    }

    public void setPokemonMoves(Set<PokemonMove> pokemonMoves) {
        this.pokemonMoves = pokemonMoves;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void addPokemonMove(PokemonMove pokemonMove) {
        pokemonMoves.add(pokemonMove);
    }

    public void removePokemonMove(PokemonMove pokemonMove) {
        pokemonMoves.remove(pokemonMove);
    }

    public void deletePokemonMoves() {
        pokemonMoves.clear();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<MoveEffect> getMoveEffects() {
        return moveEffects;
    }

    public void setMoveEffects(Set<MoveEffect> moveEffects) {
        this.moveEffects = moveEffects;
    }

    public void addMoveEffect(MoveEffect moveEffect) {
        moveEffects.add(moveEffect);
    }

    public void removeMoveEffect(MoveEffect moveEffect) {
        moveEffects.remove(moveEffect);
    }

    public void deleteMoveEffects() {
        moveEffects.clear();
    }
}
