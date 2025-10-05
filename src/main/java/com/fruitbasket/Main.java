package com.fruitbasket;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java -jar fruit-basket-app.jar <csv-file-path>");
            System.exit(1);
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("-help")) {
            System.out.println("Usage: java -jar fruit-basket-app.jar <csv-file-path>");
            System.out.println("Example: java -jar fruit-basket-app.jar src/main/resources/fruits.csv");
            System.out.println("Description:");
            System.out.println("  Processes a CSV file containing fruits and generates a summary report.");
            System.out.println("  CSV Format:");
            System.out.println("    fruit-type,age-in-days,characteristic1,characteristic2,[optional additional characteristics]");
            System.out.println("Example with dynamic characteristics:");
            System.out.println("    apple,1,round,sweet,red,year-round");
            System.exit(0);
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
