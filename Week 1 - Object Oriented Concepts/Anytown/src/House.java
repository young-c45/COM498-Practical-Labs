/*
 * House Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

// Template for House objects
public class House extends Building {
    // Declares static variables
    private static int numHouses = 0;

    // Declares instance variables
    private int numBedrooms;
    private boolean hasGarage;

    // Default constructor
    public House() {
        // Calls Building constructor
        super();
        // Sets instance variables
        numBedrooms = 0;
        hasGarage = false;

        // Increments number of houses
        numHouses++;
    }

    // Constructor with variables passed
    public House(String newAddress, String newOwner,
                 int newNumBedrooms, boolean newHasGarage) {
        // Calls Building constructor
        super(newAddress, newOwner);
        // Sets instance variables
        numBedrooms = newNumBedrooms;
        hasGarage = newHasGarage;

        // Increments number of houses
        numHouses++;
    }

    // Static accessor method for number of houses
    public static int getNumHouses() {
        // Returns house count
        return numHouses;
    }

    // Accessor method for bedroom count
    public int getNumBedrooms() {
        // Returns the number of bedrooms
        return numBedrooms;
    }

    // Mutator method for bedroom count
    public void setNumBedrooms(int newNumBedrooms) {
        // Sets the number of bedrooms
        numBedrooms = newNumBedrooms;
    }

    // Accessor method for bedroom count
    public boolean getHasGarage() {
        // Returns the number of bedrooms
        return hasGarage;
    }

    // Mutator method for bedroom count
    public void setHasGarage(boolean newHasGarage) {
        // Sets the number of bedrooms
        hasGarage = newHasGarage;
    }

    // Method to get object as readable string
    public String toString() {
        // Builds readable string
        String response = "The house at " + super.toString()
                + " has " + numBedrooms + " bedrooms and "
                + (hasGarage ? "a" : "no") + " garage";
        // Returns generated response
        return response;
    }
}
