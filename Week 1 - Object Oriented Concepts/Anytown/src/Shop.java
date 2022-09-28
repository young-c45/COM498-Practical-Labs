/*
 * Shop Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

// Template for Shop objects
public class Shop extends Building {
    // Declares static variables
    private static int numShops = 0;

    // Declares instance variables
    private int numEmployees;
    private int averageTurnover;

    // Default constructor
    public Shop() {
        // Calls Building constructor
        super();
        // Sets instance variables
        numEmployees = 0;
        averageTurnover = 0;

        // Increments number of shops
        numShops++;
    }

    // Constructor with variables passed
    public Shop(String newAddress, String newOwner,
                 int newNumEmployees, int newAverageTurnover) {
        // Calls Building constructor
        super(newAddress, newOwner);
        // Sets instance variables
        numEmployees = newNumEmployees;
        averageTurnover = newAverageTurnover;

        // Increments number of shops
        numShops++;
    }

    // Static accessor method for number of shops
    public static int getNumShops() {
        // Returns shop count
        return numShops;
    }

    // Accessor method for employee count
    public int getNumEmployees() {
        // Returns number of employees
        return numEmployees;
    }

    // Mutator method for employee count
    public void setNumEmployees(int newNumEmployees) {
        // Sets number of employees
        numEmployees = newNumEmployees;
    }

    // Accessor method for average turnover
    public int getAverageTurnover() {
        // Returns average turnover
        return averageTurnover;
    }

    // Mutator method for average turnover
    public void setAverageTurnover(int newAverageTurnover) {
        // Sets average turnover
        averageTurnover = newAverageTurnover;
    }

    // Method to get object as readable string
    public String toString() {
        // Builds readable string
        String response = "The shop at " + super.toString()
                + " has " + numEmployees + " employees and"
                + " an average annual turnover of £" + averageTurnover;
        // Returns generated response
        return response;
    }
}
