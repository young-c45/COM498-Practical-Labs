/*
 * SumOf Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 17/10/2022
 */

// Template for SumOf objects
public class SumOf {
    // Method to sum all positive integers up to n
    public static int sumOf(int n) {
        // If n is 1, returns 1
        if (n == 1) return 1;
        // Otherwise, returns n + sum of n-1
        else return n + sumOf(n - 1);
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Outputs sum of numbers
        System.out.println("The sum of the integers up to 3 is " 
                + sumOf(3));
        System.out.println("The sum of the integers up to 5 is "
                + sumOf(5));
        System.out.println("The sum of the integers up to 10 is "
                + sumOf(10));
    }
}
