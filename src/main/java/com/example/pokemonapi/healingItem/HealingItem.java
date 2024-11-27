package com.example.pokemonapi.healingItem;

import com.example.pokemonapi.effect.Effect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Table(name = "item")
@Entity
public class HealingItem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int price;
    private int healAmount;    @ManyToOne
    @JoinColumn(name = "effect_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = { "healingItems" })
    private Effect statusHeal;

    public HealingItem(String name, String description, int price, int healAmount, Effect statusHeal){

        this.name = name;
        this.description = description;
        this.price = price;
        this.healAmount = healAmount;
        this.statusHeal = statusHeal;
    }

    public HealingItem() {

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

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public Effect getStatusHeal() {
        return statusHeal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatusHeal(Effect statusHeal) {
        this.statusHeal = statusHeal;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
}
