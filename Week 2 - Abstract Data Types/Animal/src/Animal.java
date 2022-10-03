/*
 * Animal Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 03/10/2022
 */

// Template for Animal objects
public class Animal {
    // Declares instance variables
    private String foodType;
    private int lifeExpectancy;
    
    // Default constructor
    public Animal() {
        // Sets instance variables
        foodType = null;
        lifeExpectancy = 0;
    }
    
    // Constructor with food type passed
    public Animal(String newFoodType) {
        // Sets instance variables
        foodType = newFoodType;
        lifeExpectancy = 0;
    }
    
    // Constructor with life expectancy passed
    public Animal(int newLifeExpectancy) {
        // Sets instance variables
        foodType = null;
        lifeExpectancy = newLifeExpectancy;
    }
    
    // Constructor with both parameters passed
    public Animal(String newFoodType, int newLifeExpectancy) {
        // Sets instance variables
        foodType = newFoodType;
        lifeExpectancy = newLifeExpectancy;
    }
    
    // Method to get object as readable string
    public String toString() {
        // Creates the response string
        String response = "This ";
        
        // Adds the food type if set
        if (foodType != null) response += foodType + " eater ";
        // Adds the life expectancy
        response += "typically lives for " + ((lifeExpectancy == 0) ?
                "an unknown number of" : lifeExpectancy) + " years.";
        
        // Returns the response
        return response;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Creates animal objects
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(3);
        Animal animal3 = new Animal("grass");
        Animal animal4 = new Animal("meat", 10);
        
        // Writes animal info to console
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal4);
    }
}
