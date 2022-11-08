/*
 * Sort Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 08/11/2022
 */

import java.util.Arrays;

// Template for Sort objects
public class Sort {
    
    // Declares class variables
    public static int numComparisons = 0, numSwaps = 0;
    
    // Method to sort int array
    public static void bubblesort(int[] arr) {
        // Declares necessary variables
        int lastPos = arr.length - 1;
        int innerLastPos = lastPos;
        int temp;
        
        // Runs for number of items in array
        for (int i = 0; i < lastPos; i++) {
            // Runs for every unsorted item in array
            for (int j = 0; j < innerLastPos; j++) {
                // Stores that a comparison was made
                numComparisons++;
                // Swaps value at j if more than next value
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // Stores that a swap was made
                    numSwaps++;
                }
            }
            // Shrinks inner area to exclude sorted elements
            innerLastPos--;
            // Outputs information about the pass
            System.out.println("Pass " + (i+1) + ": " + Arrays.toString(arr));
            
        }
    }

    // Method to run on compile
    public static void main(String[] args) {
        // Creates array to sort
        int[] arr = { 9, 2, 7, 1, 10, 3, 6, 4, 5, 8 };
        // Outputs array
        System.out.println("Before: " + Arrays.toString(arr));
        // Outputs line for formatting
        System.out.println();
        
        // Sorts array
        bubblesort(arr);
        // Outputs result
        System.out.println("\nAfter: " + Arrays.toString(arr));
        
        // Outputs statistics
        System.out.println("\nThere were " + numComparisons 
                + " comparisons and " + numSwaps + " swaps.");
    }
}
