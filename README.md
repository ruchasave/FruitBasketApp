# FruitBasketApp
Console application for Fruit Basket App 

Input CSV example

fruit-type,age-in-days,characteristic1,characteristic2

apple,1,red,sweet

orange,2,round,sweet

pineapple,5,prickly,sweet

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

 



