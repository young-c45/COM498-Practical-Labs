/*
 * PetTest Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 27/09/2022
 */

import java.util.Random;
import java.util.Scanner;

// Class to run code to test the package
public class PetTest {
    // Creates object to get user input
    private static Scanner input = new Scanner(System.in);
    // Creates object to get random number
    private static Random random = new Random();
    
    // Creates array to store possible breeds
    private static String[] catBreeds = { "Siamese", "Burmese", "Tabby", 
            "Persian", "Manx" };
    private static String[] dogBreeds = { "Terrier", "Greyhound", "Alsatian", 
            "Spaniel", "Mongrel"};

    // Method to get random number
    private static int getRandomNum(int lowerBound, int upperBound) {
        // Returns random number between bounds
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }

    // Method to run on compile
    public static void main(String[] args) {
        // Declares array to store pets
        Pet[] pets = new Pet[5];
        // Declares variables for pet creation and search
        String petType, petName, petBreed;
        int petAge;
        boolean foundPet;

        // Runs for each pet
        int i = 0;
        while (i < pets.length) {
            // Gets desired pet
            System.out.print("Is pet " + i + " a cat or a dog? ");
            petType = input.nextLine();
            
            // Runs if type is invalid
            if (!petType.equalsIgnoreCase("dog") 
                    && !petType.equalsIgnoreCase("cat")) {
                // Tells user pet type is invalid
                System.out.println("A pet can only be a dog or a cat.");
                // Outputs blank line for formatting
                System.out.println();
                // Restarts the loop
                continue;
            }
            
            // Gets pet's name
            System.out.print("What is the pet's name? ");
            petName = input.nextLine();
            
            // Generates pet's age
            petAge = getRandomNum(1, 10);
            
            // Runs if type is dog
            if (petType.equalsIgnoreCase("dog")) {
                // Generates pet's breed
                petBreed = dogBreeds[getRandomNum(0, 
                        dogBreeds.length)];
                // Creates the pet
                pets[i] = new Dog(petName, petAge, petBreed);
            }
            // Runs if type is cat
            else if (petType.equalsIgnoreCase("cat")) {
                // Generates pet's breed
                petBreed = catBreeds[getRandomNum(0,
                        catBreeds.length)];
                // Creates the pet
                pets[i] = new Cat(petName, petAge, petBreed);
            }

            // Outputs blank line for formatting
            System.out.println();
            // Increments i
            i++;
        }
        
        // Outputs the number of cats and dogs
        System.out.println("There are " + Cat.getNumCats() + " cats and " 
                + Dog.getNumDogs() + " dogs.");
        
        // Runs until exit is entered
        do {
            // Outputs blank line for formatting
            System.out.println();
            
            // Gets name of animal to speak
            System.out.print("Which animal do you want to speak? " +
                    "(type 'exit' to quit) ");
            petName = input.nextLine();
            
            // Runs if name is not exit
            if (!petName.equalsIgnoreCase("exit")) {
                // Sets that pet hasn't been found
                foundPet = false;
                
                // Runs for each pet
                for (Pet pet : pets) {
                    // Runs if pet name is a match
                    if (pet.getName().equalsIgnoreCase(petName)) {
                        // Gets the pet to speak
                        System.out.println(pet.speak());
                        // Sets that pet has been found
                        foundPet = true;
                        // Exits the for loop
                        break;
                    }
                }
                
                // Runs if the pet was not found
                if (!foundPet) {
                    // Tells user no pet was found
                    System.out.println("We couldn't find a pet called "
                            + petName + ", please try again.");
                }
            }
        } while (!petName.equalsIgnoreCase("exit"));
    }
}
