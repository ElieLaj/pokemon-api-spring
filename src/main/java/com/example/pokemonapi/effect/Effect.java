package com.example.pokemonapi.effect;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "effect")
@Entity
public class Effect {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

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
}
