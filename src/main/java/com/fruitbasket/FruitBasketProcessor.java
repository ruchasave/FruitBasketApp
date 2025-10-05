package com.fruitbasket;

import java.util.*;
import java.util.stream.Collectors;

public class FruitBasketProcessor {

    public static int getTotalFruits(List<Fruit> fruits) {
        return fruits.size();
    }

    public static long getDistinctFruitTypes(List<Fruit> fruits) {
        return fruits.stream()
                .map(Fruit::getType)
                .distinct()
                .count();
    }

    public static Map<String, Integer> getOldestFruits(List<Fruit> fruits) {
        int maxAge = fruits.stream().mapToInt(Fruit::getAgeInDays).max().orElse(0);
        return fruits.stream()
                .filter(f -> f.getAgeInDays() == maxAge)
                .collect(Collectors.toMap(Fruit::getType, Fruit::getAgeInDays, (a, b) -> a));
    }

    public static Map<String, Long> countByType(List<Fruit> fruits) {
        return fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getType, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
    }

    public static Map<String, Long> countByTypeAndCharacteristics(List<Fruit> fruits) {
        return fruits.stream()
                .collect(Collectors.groupingBy(
                        f -> f.getType() + ": " + String.join(", ", f.getCharacteristics()),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
    }
}
