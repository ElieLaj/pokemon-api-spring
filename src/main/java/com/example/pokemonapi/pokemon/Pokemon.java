package com.example.pokemonapi.pokemon;

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
    int attack;
    int speed;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "pokemon_moves",
//            joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "move_id", referencedColumnName = "id")
//    )
//    @JsonIgnoreProperties("pokemons")
//    private List<Move> moves = new ArrayList<Move>();

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pokemon")
    private Set<PokemonMove> pokemonMoves = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pokemon_types",
            joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = { "moves", "pokemons" })
    private List<Type> types = new ArrayList<Type>();

    public Pokemon() {
    }

    public Pokemon(String name, int hp, int attack, int speed) {
        super();
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
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
}
