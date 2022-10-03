/*
 * Printer Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 03/10/2022
 */

// Template for Printer objects
public class Printer {
    // Method to print array to console
    public static <T> void printArray(T[] arr) {
        // Outputs each element in arr
        for (T element : arr) System.out.println(element);
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Creates arrays
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "one", "two", "three" };
        
        // Outputs arrays
        printArray(intArray);
        printArray(stringArray);
    }
}
