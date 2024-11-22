package com.example.pokemonapi.move;

public class MoveDTO {
    private String name;
    private String type;
    private String category;
    private String effect;
    private Long odds;
    private int power;
    private int accuracy;


    public MoveDTO(String name, String type, String category, String effect, Long odds, int power, int accuracy) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.effect = effect;
        this.odds = odds;
    }

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getEffect() {
        return effect;
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
