package com.example.pokemonapi.moveEffect;

import com.example.pokemonapi.effect.Effect;
import com.example.pokemonapi.move.Move;
import com.example.pokemonapi.pokemon.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Table(name = "move_effect")
@Entity
public class MoveEffect {
    @Id
    @GeneratedValue
    private Long id;

    private Long odds;

    @ManyToOne
    @JoinColumn(name = "move_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"moveEffects", "pokemonMoves"})
    private Move move;

    @ManyToOne
    @JoinColumn(name = "effect_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"moveEffects", "pokemonMoves"})
    private Effect effect;

    public MoveEffect() {
    }

    public MoveEffect(Long odds, Move move, Effect effect) {
        this.odds = odds;
        this.move = move;
        this.effect = effect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOdds() {
        return odds;
    }

    public void setOdds(Long odds) {
        this.odds = odds;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
