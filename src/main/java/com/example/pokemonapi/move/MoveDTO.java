package com.example.pokemonapi.move;

public class MoveDTO {
    private String name;
    private String type;
    private String category;
    private int power;
    private int accuracy;


    public MoveDTO(String name, String type, String category, int power, int accuracy) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
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

}
