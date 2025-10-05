package com.fruitbasket;

import java.util.List;
import java.util.Map;

public class FruitReport {

    public static void generateReport(List<Fruit> fruits) {
        System.out.println("Total number of fruit:");
        System.out.println(FruitBasketProcessor.getTotalFruits(fruits));

        System.out.println("Total types of fruit:");
        System.out.println(FruitBasketProcessor.getDistinctFruitTypes(fruits));

        System.out.println("Oldest fruit & age:");
        FruitBasketProcessor.getOldestFruits(fruits)
                .forEach((type, age) -> System.out.println(type + ": " + age));

        System.out.println("The number of each type of fruit in descending order:");
        FruitBasketProcessor.countByType(fruits)
                .forEach((type, count) -> System.out.println(type + ": " + count));

        System.out.println("The various characteristics (count, color, shape, etc.) of each fruit by type:");
        FruitBasketProcessor.countByTypeAndCharacteristics(fruits)
                .forEach((desc, count) -> System.out.println(count + " " + desc));
    }
}
