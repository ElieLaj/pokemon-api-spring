package com.example.pokemonapi.pokeball;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "pokeball")
@Table
public class Pokeball {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int catchRate;
    private int price;

    public Pokeball() {
    }

    public Pokeball(String name, String description, int catchRate, int price) {
        this.name = name;
        this.description = description;
        this.catchRate = catchRate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(int catchRate) {
        this.catchRate = catchRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
