package com.fruitbasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class FruitBasketProcessorTest {

    private List<Fruit> fruits;

    @BeforeEach
    void setup() {
        fruits = Arrays.asList(
                new Fruit("apple", 1, Arrays.asList("red", "sweet")),
                new Fruit("orange", 2, Arrays.asList("round", "sweet")),
                new Fruit("pineapple", 6, Arrays.asList("prickly", "sweet")),
                new Fruit("apple", 4, Arrays.asList("yellow", "sweet")),
                new Fruit("grapefruit", 3, Arrays.asList("yellow", "bitter")),
                new Fruit("orange", 6, Arrays.asList("round", "sweet"))
        );
        System.out.println("\n Test dataset initialized with " + fruits.size() + " fruits.");
    }

    @Test
    void testTotalFruitCount() {
        int total = FruitBasketProcessor.getTotalFruits(fruits);
        assertEquals(6, total, "Total fruit count should be 6");
        System.out.println("testTotalFruitCount passed: Expected 6, got " + total);
    }

    @Test
    void testDistinctFruitTypes() {
        long types = FruitBasketProcessor.getDistinctFruitTypes(fruits);
        assertEquals(4, types, "Distinct fruit types should be 4");
        System.out.println("testDistinctFruitTypes passed: Expected 4 distinct types, got " + types);
    }

    @Test
    void testOldestFruits() {
        Map<String, Integer> oldest = FruitBasketProcessor.getOldestFruits(fruits);
        assertTrue(oldest.containsKey("orange"), "Orange should be oldest");
        assertTrue(oldest.containsKey("pineapple"), "Pineapple should be oldest");
        assertEquals(6, oldest.get("orange"));
        System.out.println("testOldestFruits passed: Oldest fruits are " + oldest);
    }

    @Test
    void testCountByType() {
        Map<String, Long> countByType = FruitBasketProcessor.countByType(fruits);
        assertEquals(2L, countByType.get("orange"));
        assertEquals(2L, countByType.get("apple"));
        assertEquals(1L, countByType.get("grapefruit"));
        System.out.println("testCountByType passed: " + countByType);
    }

    @Test
    void testCountByTypeAndCharacteristics() {
        Map<String, Long> countByCombo = FruitBasketProcessor.countByTypeAndCharacteristics(fruits);
        assertTrue(countByCombo.containsKey("orange: round, sweet"));
        assertEquals(2L, countByCombo.get("orange: round, sweet"));
        System.out.println("testCountByTypeAndCharacteristics passed: " + countByCombo);
    }
}
