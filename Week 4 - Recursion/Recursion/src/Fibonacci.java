/*
 * Fibonacci Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 18/10/2022
 */

// Template for Fibonacci objects
public class Fibonacci {
    // Declares class variables
    private static int[] numOfCalls = null;
    
    // Method to get nth number in fibonacci sequence
    public static long getFibonacci(int n) {
        // Declares instance variables
        long result;
        // Stores if this is call first in chain
        boolean firstRun = (numOfCalls == null);
        
        // Creates number of calls array if first in chain
        if (firstRun) numOfCalls = new int[n + 1];
        // Add 1 to number of times method called for this n
        numOfCalls[n]++;
        
        // If n is 0 or 1, returns n
        if (n == 0 || n == 1) result = n;
        // Otherwise return sum of previous 2 fibonacci numbers
        else result = getFibonacci(n - 1) + getFibonacci(n - 2);
        
        // Runs if first in chain
        if (firstRun) {
            // Outputs header text for method analysis
            System.out.println("**************Methods Run**************");
            // Runs for every element in number of calls array
            for (int i = n; i >= 0; i--) {
                // Outputs info for i
                System.out.println("getFibonacci(" + i + ") is called "
                        + numOfCalls[i] + " times.");
            }
            // Outputs footer text for method analysis
            System.out.println("***************************************");
        }
        // Returns the result
        return result;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Output 20th number in fibonacci sequence
        System.out.println("The 20th number in the Fibonacci sequence is: " 
                + getFibonacci(20));
    }
}
