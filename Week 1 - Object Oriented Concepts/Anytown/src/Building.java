/*
 * Building Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

// Template for Building objects
public class Building {
    // Declares static variables
    private static int numBuildings = 0;

    // Declares instance variables
    private String address;
    private String owner;

    // Default constructor
    public Building() {
        // Sets instance variables
        address = "";
        owner = "";

        // Increments number of buildings
        numBuildings++;
    }

    // Constructor with variables passed
    public Building(String newAddress, String newOwner) {
        // Sets instance variables
        address = newAddress;
        owner = newOwner;

        // Increments number of buildings
        numBuildings++;
    }

    // Static accessor method for number of buildings
    public static int getNumBuildings() {
        // Returns building count
        return numBuildings;
    }

    // Accessor method for address
    public String getAddress() {
        // Returns value of address
        return address;
    }

    // Mutator method for address
    public void setAddress(String newAddress) {
        // Sets address variable
        address = newAddress;
    }

    // Accessor method for owner
    public String getOwner() {
        // Returns value of address
        return owner;
    }

    // Mutator method for owner
    public void setOwner(String newOwner) {
        // Sets address variable
        owner = newOwner;
    }

    // Method to get object as readable string
    public String toString() {
        // Builds readable string
        String response = address + " is occupied by " + owner;
        // Returns generated response
        return response;
    }
}
