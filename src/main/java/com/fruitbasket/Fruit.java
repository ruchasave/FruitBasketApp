package com.fruitbasket;

import java.util.List;

public class Fruit {
    private String type;
    private int ageInDays;
    private List<String> characteristics; // handles char1, char2, … n

    public Fruit(String type, int ageInDays, List<String> characteristics) {
        this.type = type;
        this.ageInDays = ageInDays;
        this.characteristics = characteristics;
    }

    public String getType() {
        return type;
    }

    public int getAgeInDays() {
        return ageInDays;
    }

    public List<String> getCharacteristics() {
        return characteristics;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type='" + type + '\'' +
                ", ageInDays=" + ageInDays +
                ", characteristics=" + characteristics +
                '}';
    }
}
