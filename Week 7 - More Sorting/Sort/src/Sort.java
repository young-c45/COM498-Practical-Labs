/*
 * Sort Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 08/11/2022
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.jar.JarEntry;

// Template for Sort objects
public class Sort {
    
    // Declares class variables
    public static int numComparisons = 0, numUpdates = 0;
    
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
                    //numUpdates++;
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
                    //numUpdates++;
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
    
    // Method to sort using selection sort
    public static void selectionSort(int[] arr) {
        // Declares necessary variables
        int firstPos = 0, lastPos = arr.length - 1;
        int temp, smallestPos;
        
        // Runs from first to last position
        for (int i = firstPos; i < lastPos; i++) {
            // Starts the smallest value at i
            smallestPos = i;
            // Runs from second to last positions
            for (int j = i+1; j <= lastPos; j++) {
                // Sets position as smallest if required
                if (arr[j] < arr[smallestPos]) smallestPos = j;
            }
            // Swaps smallest value to start
            temp = arr[smallestPos];
            arr[smallestPos] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to sort using recursive selection sort
    public static void recursiveSelectionSort(int[] arr, int firstPos,
                                              int lastPos) {
        // Declares necessary variables
        int temp, smallestPos;

        // Runs from first to last position
        if (firstPos < lastPos) {
            // Starts the smallest value at i
            smallestPos = firstPos;
            // Runs from second to last positions
            for (int j = firstPos+1; j <= lastPos; j++) {
                // Sets position as smallest if required
                if (arr[j] < arr[smallestPos]) smallestPos = j;
            }
            // Swaps smallest value to start
            temp = arr[smallestPos];
            arr[smallestPos] = arr[firstPos];
            arr[firstPos] = temp;
            recursiveSelectionSort(arr, firstPos+1, lastPos);
        }
    }
    
    // Method to sort using insertion sort
    public static void insertionSort(int[] arr) {
        // Declares needed variables
        int nextToInsert, index;
        
        // Runs for length of array
        for (int i = 0; i < arr.length; i++) {
            // Stores the value to sort
            nextToInsert = arr[i];
            
            // Stores starting index for comparisons
            index = i - 1;
            // Increments number of comparisons
            numComparisons++;
            // Runs until insert position found
            while (index >= 0 && arr[index] > nextToInsert) {
                // Moves value at index to next location
                arr[index+1] = arr[index];
                // Increments number of array updates
                numUpdates++;
                // Decrements index
                index--;
                // Increments number of comparisons
                numComparisons++;
            }
            // Inserts value to sort into correct position
            arr[index+1] = nextToInsert;
            // Increments number of array updates
            numUpdates++;
            // Outputs the array after this pass
            System.out.println("\tPass " + i + ": " + Arrays.toString(arr));
        }
    }

    // Method to sort using recursive insertion sort
    public static void recursiveInsertionSort(int[] arr, int firstPos,
                                              int lastPos) {
        // Declares needed variables
        int nextToInsert, index;

        // Increments number of comparisons
        numComparisons++;
        // Runs if multiple entries in subarray
        if (firstPos < lastPos) {
            // Calls self to sort array excluding last element
            recursiveInsertionSort(arr, firstPos, lastPos - 1);
            // Stores the value to sort
            nextToInsert = arr[lastPos];

            // Stores starting index for comparisons
            index = lastPos - 1;
            // Increments number of comparisons
            numComparisons++;
            // Runs until insert position found
            while (index >= 0 && arr[index] > nextToInsert) {
                // Moves value at index to next location
                arr[index+1] = arr[index];
                // Increments number of array updates
                numUpdates++;
                // Decrements index
                index--;
                // Increments number of comparisons
                numComparisons++;
            }
            // Inserts value to sort into correct position
            arr[index+1] = nextToInsert;
            // Increments number of array updates
            numUpdates++;
            // Outputs the array after this pass
            System.out.println("\tPass : " + Arrays.toString(arr));
        }
    }

    // Method to run on compile
    public static void main(String[] args) {
        // Declares test arrays
        int[] presorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] reversed = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] randomised = randomArray(10);
        
        // Resets comparison and update count
        numUpdates = 0;
        numComparisons = 0;
        // Random array sort
        System.out.println("Sorting Random Array:");
        System.out.println("\tBefore: " + Arrays.toString(randomised));
        recursiveInsertionSort(randomised, 0, randomised.length-1);
        System.out.println("\tAfter: " + Arrays.toString(randomised));
        System.out.println("\tTook " + numComparisons + " comparisons and "
                + numUpdates + " swaps.");

        // Resets comparison and update count
        numUpdates = 0;
        numComparisons = 0;
        // Presorted array sort
        System.out.println("Sorting Presorted Array:");
        System.out.println("\tBefore: " + Arrays.toString(presorted));
        recursiveInsertionSort(presorted, 0, presorted.length-1);
        System.out.println("\tAfter: " + Arrays.toString(presorted));
        System.out.println("\tTook " + numComparisons + " comparisons and "
                + numUpdates + " swaps.");

        // Resets comparison and update count
        numUpdates = 0;
        numComparisons = 0;
        // Reversed array sort
        System.out.println("Sorting Reversed Array:");
        System.out.println("\tBefore: " + Arrays.toString(reversed));
        recursiveInsertionSort(reversed, 0, reversed.length-1);
        System.out.println("\tAfter: " + Arrays.toString(reversed));
        System.out.println("\tTook " + numComparisons + " comparisons and "
                + numUpdates + " swaps.");
    }
}
