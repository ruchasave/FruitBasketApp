#!/bin/bash
echo "Running Fruit Basket App Verification Script"
echo "-------------------------------------------"

# Build the project
mvn clean package -q

# Run the app
echo "Running application with sample CSV..."
java -jar target/fruit-basket-app-1.0-SNAPSHOT.jar src/main/resources/fruits.csv > output.txt

# Verify output contains key lines
if grep -q "Total number of fruits:" output.txt && grep -q "Oldest fruit & age:" output.txt; then
    echo "Output verification passed!"
else
    echo "Output verification failed. Check output.txt"
fi

# Run tests
echo "Running JUnit tests..."
mvn test -q
