/*
 * Pet Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

import java.security.PrivateKey;

// Template for Pet objects
public class Pet {
    // Declares instance variables
    private String name;
    private int age;

    // Default constructor
    public Pet() {
        // Sets instance variables
        name = "";
        age = 0;
    }

    // Constructor with variables passed
    public Pet(String newName, int newAge) {
        // Sets instance variables
        name = newName;
        age = newAge;
    }

    // Accessor method for pet name
    public String getName() {
        // Returns pet name
        return name;
    }

    // Mutator method for pet name
    public void setName(String newName) {
        // Sets the name
        name = newName;
    }

    // Accessor method for pet age
    public int getAge() {
        // Returns pet age
        return age;
    }

    // Mutator method for pet age
    public void setAge(int newAge) {
        // Sets the age
        age = newAge;
    }
    
    // Method to get pet to speak
    public String speak() {
        // Forms and returns the message
        return "I am " + name + ", and I am " + age + " years old.";
    }

}
