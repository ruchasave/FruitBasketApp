package com.fruitbasket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitCSVReader {

    public static List<Fruit> readFruits(String filePath) throws IOException {
        List<Fruit> fruits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // skip header row
                }
                String[] tokens = line.split(",");
                if (tokens.length < 3) {
                    throw new IllegalArgumentException("Invalid CSV format: " + line);
                }
                String type = tokens[0].trim();
                int age;
                try {
                    age = Integer.parseInt(tokens[1].trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid age value: " + tokens[1]);
                }
                List<String> characteristics = Arrays.asList(Arrays.copyOfRange(tokens, 2, tokens.length));
                fruits.add(new Fruit(type, age, characteristics));
            }
        }
        return fruits;
    }
}
