package com.example.pokemonapi.effect;

import com.example.pokemonapi.moveEffect.MoveEffect;
import com.example.pokemonapi.pokemonMove.PokemonMove;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "effect")
@Entity
public class Effect {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "effect", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("effect")
    private Set<MoveEffect> moveEffects = new HashSet<>();

    public Effect() {
    }

    public Effect(String name) {
        this.name = name;
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
}
