package com.example.pokemonapi.pokemon;

import com.example.pokemonapi.stage.Stage;
import com.example.pokemonapi.type.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import com.example.pokemonapi.pokemonMove.PokemonMove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
            @SequenceGenerator(
                    name = "pokemon_sequence",
                    sequenceName = "pokemon_sequence",
                    allocationSize = 1
            )
            @GeneratedValue(
                    strategy = GenerationType.SEQUENCE,
                    generator = "pokemon_sequence"
            )
    Long id;
    String name;
    int hp;
    int maxHp;
    int attack;
    int defense;
    int specialAttack;
    int specialDefense;
    int speed;

    int expRate;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pokemon")
    private Set<PokemonMove> pokemonMoves = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "pokemon_types",
            joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = { "moves", "pokemons" })
    private List<Type> types = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "pokemon_stages",
            joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "stage_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = { "pokemons", "stages" })
    private List<Stage> stages = new ArrayList<>();


    public Pokemon() {
    }

    public Pokemon(Long id, String name, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, int expRate) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.expRate = expRate;
        this.maxHp = hp;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public void removeStage(Stage stage) {
        stages.remove(stage);
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public void addType(Type type) {
        types.add(type);
    }

    public void removeType(Type type) {
        types.remove(type);
    }

    public void deleteTypes() {
        types.clear();
    }

    public Set<PokemonMove> getPokemonMoves() {
        return pokemonMoves;
    }

    public void setPokemonMoves(Set<PokemonMove> pokemonMoves) {
        this.pokemonMoves = pokemonMoves;
    }

    public void addPokemonMove(PokemonMove pokemonMove) {
        pokemonMoves.add(pokemonMove);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getExpRate() {
        return expRate;
    }

    public void setExpRate(int expRate) {
        this.expRate = expRate;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }



}


