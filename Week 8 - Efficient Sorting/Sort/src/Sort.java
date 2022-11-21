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
            // Runs until insert position found
            while (index >= 0 && arr[index] > nextToInsert) {
                // Moves value at index to next location
                arr[index+1] = arr[index];
                // Decrements index
                index--;
            }
            // Inserts value to sort into correct position
            arr[index+1] = nextToInsert;
        }
    }

    // Method to sort using recursive insertion sort
    public static void recursiveInsertionSort(int[] arr, int firstPos,
                                              int lastPos) {
        // Declares needed variables
        int nextToInsert, index;

        // Runs if multiple entries in subarray
        if (firstPos < lastPos) {
            // Calls self to sort array excluding last element
            recursiveInsertionSort(arr, firstPos, lastPos - 1);
            // Stores the value to sort
            nextToInsert = arr[lastPos];

            // Stores starting index for comparisons
            index = lastPos - 1;
            // Runs until insert position found
            while (index >= 0 && arr[index] > nextToInsert) {
                // Moves value at index to next location
                arr[index+1] = arr[index];
                // Decrements index
                index--;
            }
            // Inserts value to sort into correct position
            arr[index+1] = nextToInsert;
        }
    }
    
    // Method to sort using shell sort
    public static void shellSort(int[] arr, int div) {
        // Declares needed variables
        int temp, index;
        
        // Runs the sort algorithm
        for (int gap = arr.length / div; gap > 0; gap /= div) {
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for (index = i; index >= gap && arr[index - gap] > temp; 
                     index -= gap) {
                    arr[index] = arr[index - gap];
                }
                arr[index] = temp;
            }
        }
    }

    // Method to sort using shell sort with mean of primes sequence
    public static void shellSort(int[] arr) {
        // Declares needed variables
        int temp, index, start = 0, gap;
        int[] sequence = { 3785, 1695, 749, 326, 138, 57, 23, 9, 4, 1};

        // Gets the starting point of the sequence
        while(sequence[start] >= arr.length) {
            start++;
        }
        
        // Runs the sort algorithm
        for (int j = start; j < sequence.length; j++) {
            gap = sequence[j];
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for (index = i; index >= gap && arr[index - gap] > temp;
                     index -= gap) {
                    arr[index] = arr[index - gap];
                }
                arr[index] = temp;
            }
        }
    }
    
    // Method to sort an array section using a merge
    public static void merge(int arr[], int first, int mid, int last) {
        // Declares needed variables
        int pos1 = first, pos2 = mid + 1, index = first;
        // Creates temporary array
        int[] temp = new int[arr.length];
        
        // Runs until a half is fully merged into temp array
        while (pos1 <= mid && pos2 <= last) {
            // Adds from first half if it's front element is smaller
            if (arr[pos1] <= arr[pos2]) temp[index++] = arr[pos1++];
            // Otherwise add from second half
            else temp[index++] = arr[pos2++];
        }
        
        // Adds the remaining elements
        while (pos1 <= mid) temp[index++] = arr[pos1++];
        while (pos2 <= last) temp[index++] = arr[pos2++];
        
        // Moves sorted array segment to original array
        for (int i = first; i <= last; i++) arr[i] = temp[i];
    }
    
    // Method to sort using merge sort
    public static void mergeSort(int[] arr, int first, int last) {
        // Only runs if at least 2 elements to sort
        if (first < last) {
            // Calculates the midpoint
            int mid = (first + last) / 2;
            // Sorts the 2 halves
            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
            // Merges the 2 halves
            merge(arr, first, mid, last);
        }
    }

    // Method to sort an array section using a merge passing temp array
    public static void merge(int[] arr, int[] temp, int first, int mid,
                             int last) {
        // Declares needed variables
        int pos1 = first, pos2 = mid + 1, index = first;

        // Runs until a half is fully merged into temp array
        while (pos1 <= mid && pos2 <= last) {
            // Adds from first half if it's front element is smaller
            if (arr[pos1] <= arr[pos2]) temp[index++] = arr[pos1++];
                // Otherwise add from second half
            else temp[index++] = arr[pos2++];
        }

        // Adds the remaining elements
        while (pos1 <= mid) temp[index++] = arr[pos1++];
        while (pos2 <= last) temp[index++] = arr[pos2++];

        // Moves sorted array segment to original array
        for (int i = first; i <= last; i++) arr[i] = temp[i];
    }

    // Method to sort using merge sort passing temp array
    public static void mergeSort(int[] arr, int[] temp, int first, int last) {
        // Only runs if at least 2 elements to sort
        if (first < last) {
            // Calculates the midpoint
            int mid = (first + last) / 2;
            // Sorts the 2 halves
            mergeSort(arr, temp, first, mid);
            mergeSort(arr, temp, mid+1, last);
            // Merges the 2 halves
            merge(arr, temp, first, mid, last);
        }
    }
    
    // Method to sort all of an array with merge sort
    public static void mergeSort(int[] arr) {
        // Creates temp array
        int[] temp = new int[arr.length];
        // Runs merge sort on array
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    
    // Method to swap 2 elements in an array
    public static void swap(int[] arr, int first, int second) {
        // Stores first value in variable
        int temp = arr[first];
        // Stores second element in first's position
        arr[first] = arr[second];
        // Stores first element in second's position
        arr[second] = temp;
    }
    
    // Method to sort array with quick sort
    public static void quickSort(int[] arr, int first, int last) {
        // Sets pivot point
        int pivot = arr[last];
        // Declares the indexes
        int indexFromLeft = first, indexFromRight = last;
        
        // Runs until indexes cross each-other
        while (indexFromLeft <= indexFromRight) {
            // Moves finds needed elements from right and left
            while (arr[indexFromLeft] < pivot) indexFromLeft++;
            while (arr[indexFromRight] > pivot) indexFromRight--;
            // Swap indexes if they have not crossed over
            if (indexFromLeft <= indexFromRight) 
                swap(arr, indexFromLeft++, indexFromRight--);
        }
        
        // Sorts subarrays if they exist
        if (first < indexFromRight) quickSort(arr, first, indexFromRight);
        if (indexFromLeft < last) quickSort(arr, indexFromLeft, last);
        
    }

    // Method to sort array with quick sort, using insertion for length <= 100
    public static void quickAndInsertionSort(int[] arr, int first, int last) {
        // Uses insertion sort for lengths <= 100
        if (last - first <= 100) {
            recursiveInsertionSort(arr, first, last);
        }
        // Otherwise use quick sort
        else {
            // Sets pivot point
            int pivot = arr[last];
            // Declares the indexes
            int indexFromLeft = first, indexFromRight = last;

            // Runs until indexes cross each-other
            while (indexFromLeft <= indexFromRight) {
                // Moves finds needed elements from right and left
                while (arr[indexFromLeft] < pivot) indexFromLeft++;
                while (arr[indexFromRight] > pivot) indexFromRight--;
                // Swap indexes if they have not crossed over
                if (indexFromLeft <= indexFromRight)
                    swap(arr, indexFromLeft++, indexFromRight--);
            }

            // Sorts subarrays if they exist
            if (first < indexFromRight) quickSort(arr, first, indexFromRight);
            if (indexFromLeft < last) quickSort(arr, indexFromLeft, last);
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
        /* Function tests *
        // Declares test arrays
        int[] presorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] reversed = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] randomised = randomArray(10);
        
        // Random array sort
        System.out.println("Sorting Random Array:");
        System.out.println("\tBefore: " + Arrays.toString(randomised));
        quickSort(randomised, 0, randomised.length - 1);
        System.out.println("\tAfter: " + Arrays.toString(randomised));

        // Presorted array sort
        System.out.println("Sorting Presorted Array:");
        System.out.println("\tBefore: " + Arrays.toString(presorted));
        quickSort(presorted, 0, presorted.length - 1);
        System.out.println("\tAfter: " + Arrays.toString(presorted));

        // Reversed array sort
        System.out.println("Sorting Reversed Array:");
        System.out.println("\tBefore: " + Arrays.toString(reversed));
        quickSort(reversed, 0, reversed.length - 1);
        System.out.println("\tAfter: " + Arrays.toString(reversed));
         */
        
        /* Timing tests */
        // Declares needed variables
        int[] arr;
        long startTime, endTime;
        int[] arraySizes = { 100, 200, 400, 800, 1600, 3200, 6400, 10000,
                50000, 100000 };
        long[][] sortTimes = new long[2][arraySizes.length];
        
        // Runs for every size of array in list
        for (int a=0; a < arraySizes.length; a++) {
            // Stores start time
            startTime = System.currentTimeMillis();
            // Runs 1000 times
            for (int i=0; i < 1000; i++) {
                // Generates random array
                arr = randomArray(arraySizes[a]);
                // Sorts array
                quickSort(arr, 0, arr.length-1);
            }
            // Stores end time
            endTime = System.currentTimeMillis();
            // Stores the time taken
            sortTimes[0][a] = endTime - startTime;
        }

        // Runs for every size of array in list
        for (int a=0; a < arraySizes.length; a++) {
            // Stores start time
            startTime = System.currentTimeMillis();
            // Runs 1000 times
            for (int i=0; i < 1000; i++) {
                // Generates random array
                arr = randomArray(arraySizes[a]);
                // Sorts array
                quickAndInsertionSort(arr, 0, arr.length-1);
            }
            // Stores end time
            endTime = System.currentTimeMillis();
            // Stores the time taken
            sortTimes[1][a] = endTime - startTime;
        }
        
        // Outputs heading for the results table
        System.out.println("Size\tAlone\tw/ Insertion");
        System.out.println("-------------------------------------");
        // Runs for every array size
        for (int a = 0; a < arraySizes.length; a++) {
            // Outputs the timings for this array size
            System.out.println(arraySizes[a] + " \t" + sortTimes[0][a] 
                    + "  \t" + sortTimes[1][a]);
        }
         //*/
    }
}
