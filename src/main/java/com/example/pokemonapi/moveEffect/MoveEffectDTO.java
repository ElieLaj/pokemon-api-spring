package com.example.pokemonapi.moveEffect;

public class MoveEffectDTO {
    private String move;
    private String effect;
    private Long odds;

    public MoveEffectDTO(String move, String effect, Long odds) {
        this.move = move;
        this.effect = effect;
        this.odds = odds;
    }

    public String getMove() {
        return move;
    }

    public String getEffect() {
        return effect;
    }

    public void setMove(String name) {
        this.move = name;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Long getOdds() {
        return odds;
    }

    public void setOdds(Long odds) {
        this.odds = odds;
    }
}
