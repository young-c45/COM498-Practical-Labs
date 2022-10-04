/*
 * TestAnimal Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 04/10/2022
 */

// Template for TestAnimal objects
public class TestAnimal {
    // Method to run on compile
    public static void main(String[] args) {
        // Creates lion objects
        Lion myLion1 = new Lion("meat", 10,
                1, "Leo");
        Lion myLion2 = new Lion();
        
        // Sets lion 1's age to 3
        myLion1.setAge(3);
        
        // Outputs information about the lions
        System.out.println(myLion1);
        System.out.println(myLion2);
        // Outputs number of created lions
        System.out.println(Lion.numberOfLions() + " lions have been created.");
    }
}
