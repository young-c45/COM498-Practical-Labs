/*
 * Decimal2Binary Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 17/10/2022
 */

// Template for Decimal2Binary objects
public class Decimal2Binary {
    // Method to convert number to binary
    public static String toBinary(int n) {
        // Returns 1 if n is 1
        if (n == 1) return "1";
        // Else, converts half n to binary, and returns result and remainder
        else return toBinary(n / 2) + (n % 2);
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Outputs binary conversions
        System.out.println("26 in binary is " + toBinary(26));
        System.out.println("10 in binary is " + toBinary(10));
        System.out.println("100 in binary is " + toBinary(100));
    }
}
