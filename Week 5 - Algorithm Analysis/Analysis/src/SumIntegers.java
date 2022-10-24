/*
 * SumIntegers Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 24/10/2022
 */

// Template for SumIntegers objects
public class SumIntegers {
    // Algorithm A: Calculate 1+2+...n with a single for loop
    public static long sumA(long n) {
        // Declares variable to store sum result
        long sum = 0;
        // Runs n times
        for (int i = 1; i <= n; i++) {
            // Adds loop number to sum
            sum = sum + i;
        }
        // Returns result of sum
        return sum;
    }
    
    // Algorithm B: Calculate 1+2+...n with nested for loops
    public static long sumB(long n) {
        // Declares variable to store sum result
        long sum = 0;
        // Runs n times
        for (int i = 1; i <= n; i++) {
            // Runs i times
            for (int j = 1; j <= i; j++) {
                // Adds 1 to sum
                sum += 1;
            }
        }
        // Returns result of sum
        return sum;
    }
    
    // Algorithm C: Calculate 1+2+...n with an algebraic expression
    public static long sumC(long n) {
        // Declares variable to store sum result
        long sum = 0;
        // Calculates the sum
        sum = n * (n+1) / 2;
        // Returns result of sum
        return sum;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Declares needed variables
        long startTime, endTime;
        
        // Store start time
        startTime = System.nanoTime();
        // Run algorithm A
        System.out.println(sumA(10000));
        // Store end time
        endTime = System.nanoTime();
        // Output the time taken
        System.out.println("Algorithm A: " + (endTime-startTime) + "ns\n");

        // Store start time
        startTime = System.nanoTime();
        // Run algorithm B
        System.out.println(sumB(10000));
        // Store end time
        endTime = System.nanoTime();
        // Output the time taken
        System.out.println("Algorithm B: " + (endTime-startTime) + "ns\n");

        // Store start time
        startTime = System.nanoTime();
        // Run algorithm C
        System.out.println(sumC(10000));
        // Store end time
        endTime = System.nanoTime();
        // Output the time taken
        System.out.println("Algorithm C: " + (endTime-startTime) + "ns\n");
    }
}
