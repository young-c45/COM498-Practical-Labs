/*
 * SumAnalysis Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 25/10/2022
 */

// Template for SumAnalysis objects
public class SumAnalysis {
    // Sets the number of runs to perform
    private static final int NUM_OF_RUNS = 7;
    
    // Method to run on compile
    public static void main(String[] args) {        
        // Declares needed variables
        long startTime, endTime, n;
        long[][] timings = new long[NUM_OF_RUNS][4];
        String valueStr;
        boolean firstRow;
        
        // Gets java to cache tested algorithms
        SumIntegers.sumA(0);
        SumIntegers.sumB(0);
        SumIntegers.sumC(0);
        
        // Runs for number of times to run
        for (int i = 0; i < NUM_OF_RUNS; i++) {
            // Gets n (10^i)
            n = (long) Math.pow(10, i);
            // Stores n in timings array
            timings[i][0] = n;
            
            // Runs and times algorithm A
            startTime = System.nanoTime();
            SumIntegers.sumA(n);
            endTime = System.nanoTime();
            // Stores time taken in timings array
            timings[i][1] = endTime - startTime;

            // Runs and times algorithm B
            startTime = System.nanoTime();
            SumIntegers.sumB(n);
            endTime = System.nanoTime();
            // Stores time taken in timings array
            timings[i][2] = endTime - startTime;

            // Runs and times algorithm C
            startTime = System.nanoTime();
            SumIntegers.sumC(n);
            endTime = System.nanoTime();
            // Stores time taken in timings array
            timings[i][3] = endTime - startTime;
        }
        
        // Outputs formatting for timings table
        System.out.println(" Value of n\t\tAlgorithm A\t\tAlgorithm B" +
                "\t\tAlgorithm C");
        // Runs for every array in timings array
        for (long[] values : timings) {
            // Sets adding first row
            firstRow = true;
            // Runs for every value in values array
            for (long valueLong : values) {
                // Converts value to string
                valueStr = "" + valueLong;
                // Runs until string is 11 characters long
                while (valueStr.length() < 11) {
                    // Adds space to start of string
                    valueStr = " " + valueStr;
                }
                // If adding first, set not adding first row for next iteration
                if (firstRow) firstRow = false;
                // If not adding first row, add tab to start of string
                else valueStr = "\t\t" + valueStr;
                // Output value to console
                System.out.print(valueStr);
            }
            // Moves to next line
            System.out.println();
        }
    }
}
