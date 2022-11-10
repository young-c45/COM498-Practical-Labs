/*
 * Sort Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 08/11/2022
 */

import java.util.Arrays;
import java.util.Random;

// Template for Sort objects
public class Sort {
    
    // Declares class variables
    public static int numComparisons = 0, numSwaps = 0;
    
    // Inefficient method to sort int array
    public static void bubblesort_slow(int[] arr) {
        // Declares necessary variables
        int lastPos = arr.length - 1;
        int innerLastPos = lastPos;
        int temp;
        
        // Runs for number of items in array
        for (int i = 0; i < lastPos; i++) {
            // Runs for every unsorted item in array
            for (int j = 0; j < innerLastPos; j++) {
                // Stores that a comparison was made
                //numComparisons++;
                // Swaps value at j if more than next value
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // Stores that a swap was made
                    //numSwaps++;
                }
            }
            // Shrinks inner area to exclude sorted elements
            innerLastPos--;
            
        }
    }

    // Efficient method to sort int array
    public static void bubblesort(int[] arr) {
        // Declares necessary variables
        int firstPos = 0, lastPos = arr.length - 1;
        int temp, lastSwapPos;

        // Runs until array is sorted
        while (firstPos < lastPos) {
            // Sets the last swapped position to the first position
            lastSwapPos = firstPos;
            // Runs for every unsorted item in array
            for (int j = firstPos; j < lastPos; j++) {
                // Stores that a comparison was made
                //numComparisons++;
                // Swaps value at j if more than next value
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // Stores that a swap was made
                    //numSwaps++;
                    // Sets the last swapped position to this position
                    lastSwapPos = j;
                }
            }
            // Shrinks inner area to exclude sorted elements
            lastPos = lastSwapPos;

        }
    }
    
    // Method to generate a random integer array
    public static int[] randomArray(int n) {
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

    // Method to run on compile
    public static void main(String[] args) {
        // Declares timing variables
        long startTime, endTime;
        // Declares array to sort
        int[] arr;
        // Creates array of array sizes to test
        int[] arraySizes = {100, 200, 400, 800, 1600, 3200, 6400};
        
        // Runs for each size of array to test
        for (int size : arraySizes) {
            // Gets the starting time
            startTime = System.currentTimeMillis();
            // Sorts 1000 random arrays
            for (int i = 0; i < 1000; i++) {
                arr = randomArray(size);
                bubblesort(arr);
            }
            // Gets the ending time
            endTime = System.currentTimeMillis();
            // Outputs time taken
            System.out.println(size + " \t" + (endTime - startTime));
        }
    }
}
