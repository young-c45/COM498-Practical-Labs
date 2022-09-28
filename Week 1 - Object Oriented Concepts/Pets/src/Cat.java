/*
 * Cat Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

// Template for Cat objects
public class Cat extends Pet {
    // Declares static variables
    private static int numCats = 0;
    
    // Declares instance variables
    private String breed;

    // Default constructor
    public Cat() {
        // Calls Pet constructor
        super();
        // Sets instance variables
        breed = "";
        
        // Increments number of cats
        numCats++;
    }

    // Constructor with variables passed
    public Cat(String newName, int newAge, String newBreed) {
        // Calls Pet constructor
        super(newName, newAge);
        // Sets instance variables
        breed = newBreed;

        // Increments number of cats
        numCats++;
    }

    // Accessor method for number of cats
    public static int getNumCats() {
        // Returns number of cats created
        return numCats;
    }

    // Accessor method for breed
    public String getBreed() {
        // Returns cat's breed
        return breed;
    }

    // Mutator method for breed
    public void setBreed(String newBreed) {
        // Sets cat's breed
        breed = newBreed;
    }

    // Method to get cat to speak
    public String speak() {
        // Forms and returns the message
        return "Miaow! I am " + super.getName() + ", a " + super.getAge()
                + " year old " + breed + ".";
    }
}
