package com.fruitbasket;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java -jar fruit-basket-app.jar <csv-file-path>");
            System.exit(1);
        }

        String filePath = args[0];
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Error: File does not exist.");
            System.exit(1);
        }

        try {
            List<Fruit> fruits = FruitCSVReader.readFruits(filePath);
            FruitReport.generateReport(fruits);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            System.exit(3);
        }
    }
}
