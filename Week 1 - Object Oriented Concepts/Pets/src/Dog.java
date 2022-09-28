/*
 * Dog Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

// Template for Dog objects
public class Dog extends Pet {
    // Declares static variables
    private static int numDogs = 0;
    
    // Declares instance variables
    private String breed;

    // Default constructor
    public Dog() {
        // Calls Pet constructor
        super();
        // Sets instance variables
        breed = "";

        // Increments number of dogs
        numDogs++;
    }

    // Constructor with variables passed
    public Dog(String newName, int newAge, String newBreed) {
        // Calls Pet constructor
        super(newName, newAge);
        // Sets instance variables
        breed = newBreed;

        // Increments number of dogs
        numDogs++;
    }
    
    // Accessor method for number of dogs
    public static int getNumDogs() {
        // Returns number of dogs created
        return numDogs;
    }

    // Accessor method for breed
    public String getBreed() {
        // Returns dog's breed
        return breed;
    }

    // Mutator method for breed
    public void setBreed(String newBreed) {
        // Sets dog's breed
        breed = newBreed;
    }

    // Method to get dog to speak
    public String speak() {
        // Forms and returns the message
        return "Woof! I am " + super.getName() + ", a " + super.getAge()
                + " year old " + breed + ".";
    }
}
