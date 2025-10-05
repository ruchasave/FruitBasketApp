# FruitBasketApp
Console application for Fruit Basket App 

Usage: java -jar fruit-basket-app.jar <csv-file-path>

**Input CSV example:**

fruit-type,age-in-days,characteristic1,characteristic2

apple,1,red,sweet

orange,2,round,sweet

pineapple,5,prickly,sweet

**Output:**
When you run the Fruit Basket App with a valid CSV file, it produces a summary report with the following details:

Total number of fruits — how many entries are in the CSV.

Total number of distinct fruit types — unique kinds of fruits (e.g., apple, orange, pineapple).

Oldest fruit(s) and their age — the fruit(s) with the maximum age-in-days.

Count of each fruit type (in descending order) — a quick overview of how many of each type are in the basket.

Count of fruits grouped by both type and characteristics (in descending order) — shows how many fruits share the same color/shape/flavor traits.

# Sample Run
Command

java -jar target/fruit-basket-app-1.0-SNAPSHOT.jar src/main/resources/fruits.csv

Console Output

Processing file: src/main/resources/fruits.csv

Total number of fruits: 22
Total types of fruits: 5

Oldest fruit & age:
  orange: 6
  pineapple: 6

The number of each type of fruit in descending order:
  orange: 6
  apple: 5
  pineapple: 4
  grapefruit: 4
  watermelon: 3

The various characteristics (count, color, shape, etc.) of each fruit by type:
  3 apple: red, sweet
  5 orange: round, sweet
  2 pineapple: prickly, sweet
  1 apple: yellow, sweet
  2 grapefruit: yellow, bitter
  1 watermelon: green, heavy
  1 apple: green, tart
  2 grapefruit: bitter, yellow
  2 watermelon: heavy, green
  1 orange: sweet, round
  2 pineapple: sweet, prickly
  1 apple: red, sweet


# Project Structure
FruitBasket/

├── pom.xml

├── README.md

├── .gitignore

├── src/

│ ├── main/

│ │ ├── java/com/fruitbasket/

│ │ │ ├── Fruit.java

│ │ │ ├── FruitCSVReader.java

│ │ │ ├── FruitBasketProcessor.java

│ │ │ ├── FruitReport.java

│ │ │ └── Main.java

│ │ └── resources/

│ │ └── fruits.csv

│ └── test/

│ └── java/com/fruitbasket/

│ └── FruitBasketProcessorTest.java

└── target/

# Prerequisites
- Java 21 or higher  
- Maven 3.9+  
- Git (for cloning the repo)

# Clone the Repository
git clone https://github.com/ruchasave/FruitBasketApp.git

cd FruitBasket

# Build the Project
mvn clean package [ this will create the JAR under target/fruit-basket-app-1.0-SNAPSHOT.jar]

# Run the Application
java -jar target/fruit-basket-app-1.0-SNAPSHOT.jar src/main/resources/fruits.csv

# Running Unit Tests
 mvn test

# Feature Summary
1. File Validation - Checks if the file exists and follows the expected CSV format
2. Error Handling - Prints descriptive messages and exit codes for invalid inputs
3. Summary Report - Provides detailed fruit count breakdowns
4. Extensible Design - Easily adaptable for extra characteristics (e.g., char3, char4)
5. JUnit 5 Tests - Covers TotalFruitCount, DistinctFruitTypes, OldestFruits, CountByType, CountByTypeandCharacteristics.

 



