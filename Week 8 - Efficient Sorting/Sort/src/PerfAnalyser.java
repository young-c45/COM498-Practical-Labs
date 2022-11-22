/*
 * PerfAnalyser Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 21/11/2022
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Template for PerfAnalyser objects
public class PerfAnalyser {
    // Declares class variables
    public static String[] METHODS = {"Bubble sort", "Selection sort", 
            "Insertion sort",
            "Shell sort", "Merge sort", "Quicksort"};
    
    // Method to generate a random integer array
    private static int[] randomArray(int n) {
        // Creates object to generate random numbers
        Random random = new Random();
        // Declares array of size n
        int[] arr = new int[n];

        // Fills array with random numbers
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }

        // Returns array
        return arr;
    }
    
    // Method to run test
    public static void runTest(int method, int[] tests) {
        // Declares needed variables
        long startTime, endTime;
        long[] timeTaken = new long[tests.length];
        int[] testArray;
        String outputLine, outputChunk;
        double rateOfIncrease;
        
        for (int i = 0; i < tests.length; i++) {
            // Generates the random array
            testArray = randomArray(tests[i]);
            // Selects the method
            switch (method) {
                case 1:
                    startTime = System.nanoTime();
                    Sort.bubblesort(testArray);
                    endTime = System.nanoTime();
                    timeTaken[i] = endTime - startTime;
                    break;
                case 2:
                    startTime = System.nanoTime();
                    Sort.selectionSort(testArray);
                    endTime = System.nanoTime();
                    timeTaken[i] = endTime - startTime;
                    break;
                case 3:
                    startTime = System.nanoTime();
                    Sort.insertionSort(testArray);
                    endTime = System.nanoTime();
                    timeTaken[i] = endTime - startTime;
                    break;
                case 4:
                    startTime = System.nanoTime();
                    Sort.shellSort(testArray);
                    endTime = System.nanoTime();
                    timeTaken[i] = endTime - startTime;
                    break;
                case 5:
                    startTime = System.nanoTime();
                    Sort.mergeSort(testArray);
                    endTime = System.nanoTime();
                    timeTaken[i] = endTime - startTime;
                    break;
                case 6:
                    startTime = System.nanoTime();
                    Sort.quickSort(testArray, 0, testArray.length-1);
                    endTime = System.nanoTime();
                    timeTaken[i] = endTime - startTime;
                    break;
                default:
                    System.out.print("Could not find method " + method);
                    return;
            }
        }

        // Outputs result formatting
        System.out.println("\n--------------------------");
        System.out.println("Results for " + METHODS[method-1] + "...");
        System.out.println("--------------------------");
        System.out.println("       Array Size   Sort Time (ns) "
                + "Rate of Increase");
        // Runs for each result in time taken array
        for (int j = 0; j < timeTaken.length; j++) {
            // Stores test size as string
            outputChunk = "" + tests[j];
            // Adds spaces until string is correct length
            while (outputChunk.length() < 17)
                outputChunk = " " + outputChunk;
            // Adds test size to output
            outputLine = outputChunk;

            // Stores time taken as string
            outputChunk = "" + timeTaken[j];
            // Adds spaces until string is correct length
            while (outputChunk.length() < 17)
                outputChunk = " " + outputChunk;
            // Adds time taken to output
            outputLine += outputChunk;

            // Calculates rate of increase where possible
            if (j > 0) {
                rateOfIncrease = (((double) timeTaken[j] - 
                        (double) timeTaken[j-1]) / (double) timeTaken[j-1]) 
                        * 100 ;
                outputChunk = String.format("%1$,.2f", rateOfIncrease) + "%";
            } else {
                outputChunk = "N/A";
            }
            // Adds spaces until string is correct length
            while (outputChunk.length() < 17)
                outputChunk = " " + outputChunk;
            // Adds rate of increase to output
            outputLine += outputChunk;

            // Outputs the information
            System.out.println(outputLine);
        }
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Declares needed constants
        int[] TESTS = {10, 100, 1000, 10000, 100000, 1000000};
        Scanner INPUT = new Scanner(System.in);
        
        // Declares needed variables
        int method = -1;
        String methodString;
        
        // Outputs method options
        System.out.println("Choose a sort algorithm...");
        System.out.println("--------------------------");
        for (int i = 1; i <= METHODS.length; i++) {
            System.out.println(i + ". " + METHODS[i-1]);
        }
        System.out.println("--------------------------");
        
        // Runs until method is selected
        while (method <= 0 || method > METHODS.length) {
            // Gets the input
            System.out.print(">>> ");
            methodString = INPUT.nextLine();
            
            // Tries to convert input to int
            try {
                method = Integer.parseInt(methodString);
                // Outputs error message if input out of range
                if (method <= 0 || method > METHODS.length) {
                    System.out.println("Please input a number between 1 and "
                            + METHODS.length + "!");
                }
            }
            // Catches non-int input
            catch (NumberFormatException e) {
                // Outputs error message
                System.out.println("Please input a number between 1 and "
                        + METHODS.length + "!");
                
            }
        }
        
        // Runs tests
        runTest(method, TESTS);
    }
}
