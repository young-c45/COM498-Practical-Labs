/*
 * Lion Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 04/10/2022
 */

// Template for Lion objects
public class Lion extends Animal {
    // Declares class variables
    private static int numLions = 0;
    
    // Declares instance variables
    private int age;
    private String name;
    
    // Default constructor
    public Lion() {
        // Calls animal constructor
        super();
        // Sets instance variables
        age = -1;
        name = null;
        
        // Increments the number of lions
        numLions++;
    }
    
    // Constructor with all parameters passed
    public Lion(String newFoodType, int newLifeExpectancy, int newAge,
                String newName) {
        // Calls animal constructor
        super(newFoodType, newLifeExpectancy);
        // Sets instance variables
        age = newAge;
        name = newName;

        // Increments the number of lions
        numLions++;        
    }
    
    // Method to get total number of lions
    public static int numberOfLions() {
        // Returns count of created lion objects
        return numLions;
    }
    
    // Method to set lion's age
    public void setAge(int newAge) {
        // Sets age to given value
        age = newAge;
    }
    
    // Method to get object as readable string
    public String toString() {
        // Adds the name to the response if available
        String response = (name != null) ? name : "This animal";
        // Adds between text for formatting
        response += " is a ";
        // Adds the age if available
        if (age >= 0) response += age + " year old ";
        // Adds the animal information
        response += "Lion. " + super.toString();
        
        // Returns the generated string
        return response;
    }
}
