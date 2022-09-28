/*
 * AnytownTest Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

import java.util.Random;
import java.util.Scanner;

// Class to run code for the package
public class AnytownTest {
    // Creates scanner for user input
    private static Scanner input = new Scanner(System.in);

    // Method to get random number
    private static int getRandomValue(int low, int high) {
        // Create object for generating random numbers
        Random random = new Random();
        // Return the next random number raised to the lower bounds
        return random.nextInt(high - low) + low;
    }

    // Method to run on compile
    public static void main(String[] args) {
/*******************************1.1******************************************/
//        // Creates the building objects
//        Building building1 = new Building();
//        Building building2 = new Building("3 High Street",
//                "Fred's Soup Factory");
//        Building building3 = new Building("5 High Street",
//                "Ned's Better Soup");
//
//        // Sets information for building 1
//        building1.setAddress("27 High Street");
//        building1.setOwner("Village News");
//
//        // Overwrites information for building 3
//        building3.setAddress("13 Low Street");
//        building3.setOwner("John Smith");
//
//        // Outputs information from building 3
//        System.out.println("The address of building 1 is "
//                + building1.getAddress());
//        System.out.println("The owner of building 1 is "
//                + building1.getOwner());
//
//        // Outputs the other buildings
//        System.out.println();
//        System.out.println(building2.toString());
//        System.out.println(building3);

/*******************************1.2******************************************/
//        // Creates the House objects
//        House house1 = new House();
//        House house2 = new House("12 Main Street",
//                "Roy Cooper", 3, true);
//
//        // Sets information for house 1
//        house1.setAddress("11 Main Street");
//        house1.setOwner("Ray Cooper");
//        house1.setNumBedrooms(4);
//        house1.setHasGarage(false);
//
//        // Outputs information about the houses
//        System.out.println(house1);
//        System.out.println(house2);
//
//        // Changes information for house 2
//        house2.setNumBedrooms(2);
//        house2.setHasGarage(false);
//
//        // Outputs information about house 2
//        System.out.println(house2);
//
//        // Outputs blank line for formatting
//        System.out.println();
//
//        // Creates the Shop objects
//        Shop shop1 = new Shop();
//        Shop shop2 = new Shop("8 Low Street",
//                "Carol's Cakes", 5,
//                100);
//
//        // Sets information for shop 1
//        shop1.setAddress("7 Low Street");
//        shop1.setOwner("Brain's Buns");
//        shop1.setNumEmployees(7);
//        shop1.setAverageTurnover(250000);
//
//        //Outputs information about the shops
//        System.out.println(shop1);
//        System.out.println(shop2);
//
//        // Changes information for shop 2
//        shop2.setNumEmployees(3);
//        shop2.setAverageTurnover(90000);
//
//        // Outputs information for shop 2
//        System.out.println(shop2);

/*******************************1.3******************************************/
        // Declares array of buildings
        Building[] buildings = new Building[10];
        // Declares variables for creating buildings
        String address;
        String owner;
        int numBedrooms;
        boolean hasGarage;
        int numEmployees;
        int averageTurnover;

        // Runs for first half of buildings
        for (int i = 0; i < (buildings.length / 2); i++) {
            // Creates address from number of loops
            address = "" + (31+i) + " Main Street";
            // Gets name of owner
            System.out.print("Enter the name of the owner of building "
                    + (i + 1) + " > ");
            owner = input.next();
            // Generates number of bedrooms
            numBedrooms = getRandomValue(1, 5);
            // Decides if the house has a garage
            hasGarage = getRandomValue(0, 100) < 50 ? true : false;
            // Creates house for buildings array
            buildings[i] = new House(address, owner, numBedrooms, hasGarage);
        }

        // Runs for last half of buildings
        for (int i = buildings.length / 2; i < buildings.length; i++) {
            // Creates address
            address = "" + (i) + " Main Street";
            // Gets name of owner
            System.out.print("Enter the name of the owner of building "
                    + (i + 1) + " > ");
            owner = input.next();
            // Generates turnover
            averageTurnover = getRandomValue(10000, 1000000);
            // Generates number of employees
            numEmployees = getRandomValue(5, 50);
            // Creates shop for buildings array
            buildings[i] = new Shop(address, owner, numEmployees,
                    averageTurnover);
        }

        // Runs for each building in buildings
        for (Building building : buildings) {
            System.out.println(building);
        }

        // Outputs blank line for formatting
        System.out.println();

        // Outputs the number of buildings
        System.out.println("There are a total of "
                + Building.getNumBuildings() + " buildings of which "
                + House.getNumHouses() + " are houses and "
                + Shop.getNumShops() + " are shops.");
    }
}
