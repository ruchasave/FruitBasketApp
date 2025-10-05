package com.fruitbasket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitCSVReader {

    public static List<Fruit> readFruits(String filePath) {
        List<Fruit> fruits = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // skip header row
                    isHeader = false;
                    continue;
                }

                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Invalid CSV format: each line must have at least 3 columns");
                }

                String fruitType = parts[0].trim();
                int ageInDays;
                try {
                    ageInDays = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid age value: " + parts[1]);
                }

                // Dynamic: all remaining columns = characteristics
                List<String> characteristics = new ArrayList<>();
                if (parts.length > 2) {
                    characteristics.addAll(Arrays.asList(parts).subList(2, parts.length));
                }

                fruits.add(new Fruit(fruitType, ageInDays, characteristics));
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading file: " + e.getMessage());
        }

        return fruits;
    }
}
