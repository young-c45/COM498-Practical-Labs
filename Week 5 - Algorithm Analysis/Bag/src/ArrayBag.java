/*
 * ArrayBag Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 03/10/2022
 */

import java.lang.reflect.Array;

// Template for ArrayBag objects
public final class ArrayBag<T> implements BagInterface<T> {
    // Declares class variables
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    // Declares instance variables
    private T[] bag;
    private int numberOfEntries;
    private boolean initialised = false;
    
    // Default constructor
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }
    
    // Constructor with capacity passed
    public ArrayBag(int capacity) {
        // Runs if the max capacity is not exceeded
        if (capacity <= MAX_CAPACITY) {
            // Creates the bag array
            T[] tempBag = (T[]) new Object[capacity];
            bag = tempBag;
            // Sets the number of entries to none
            numberOfEntries = 0;
            // Sets that the object was correctly initialised
            initialised = true;
        }
        // Throws exception if capacity is too large
        else throw new IllegalStateException("Attempt to create bag where the" +
                " capacity exceeds the maximum");
    }
    
    // Method to get if array is full
    private boolean isArrayFull() {
        // Returns true if no more entries can fit in the bag
        return (bag.length <= numberOfEntries);
    }
    
    // Method to get if object was correctly initialised
    private void checkInitialisation() {
        // Throws error if object was not correctly initialised
        if (!initialised)
            throw new SecurityException("ArrayBag object is not initialised " +
                    "properly");
    }
    
    // Method to remove element at index
    private T removeElementsAt(int index) {
        // Checks if object was initialised correctly
        checkInitialisation();
        // Declares variable to store removed element
        T response = null;
        // Runs if array is not empty and index is valid
        if (!isEmpty() && index >= 0 && index < numberOfEntries) {
            // Stores element to be removed
            response = bag[index];
            // Decrements number of elements, then replaces element to be
            // removed with last element in array
            bag[index] = bag[--numberOfEntries];
            // Removes last element in array
            bag[numberOfEntries] = null;
        }
        // Returns removed element
        return response;
    }
    
    // Method to get size of bag
    public int getCurrentSize() {
        // Returns number of elements in bag
        return numberOfEntries;
    }

    // Method to get if bag is empty
    public boolean isEmpty() {
        // Returns true if there are no elements in bag
        return (numberOfEntries == 0);
    }

    // Method to add element to bag
    public boolean addNewEntry(T anEntry) {
        // Checks if object was initialised correctly
        checkInitialisation();
        // Fails if array is full
        if (isArrayFull()) return false;
        // Runs if array is not full
        else {
            // Adds entry, then increments number of entries
            bag[numberOfEntries++] = anEntry;
            // Returns indicating success
            return true;
        }
    }

    // Method to remove last element from bag
    public T remove() {
        // Removes and returns last element in array
        return removeElementsAt(numberOfEntries - 1);
    }

    // Method to remove specific element from bag
    public boolean remove(T anEntry) {
        // Declares variable to store if object is found
        boolean found = false;

        // Declares variable to store number of loops
        int index = 0;
        // Runs until object found or array fully searched
        while (!found && index < numberOfEntries) {
            // Sets found to true if element at index is object to be found
            if (bag[index].equals(anEntry)) found = true;
            // Increments index if element is not object to be found
            else index++;
        }
        
        // If element is found, removes element
        if (found) removeElementsAt(index);
        // Returns true if element was found and removed
        return found;
    }

    // Method to remove all elements from bag
    public void clear() {
        // Removes last element until none are left
        while (!isEmpty()) remove();
    }

    // Method to get frequency of element in bag
    public int getFrequencyOf(T anEntry) {
        // Declares variable to count occurrences
        int count = 0;
        // Runs for amount of elements in bag
        for (int i = 0; i < numberOfEntries; i++)
            // Increments count if element is object to count
            if (bag[i].equals(anEntry)) count++;
        // Returns count of counted object in bag
        return count;
    }

    // Method to get if element is in bag
    public boolean contains(T anEntry) {
        // Declares variable to store if object is found
        boolean found = false;
        
        // Declares variable to store number of loops
        int index = 0;
        // Runs until object found or array fully searched
        while (!found && index < numberOfEntries)
            // Sets found to true if element at index is object to be found,
            // then increments index
            if (bag[index++].equals(anEntry)) found = true;
        // Returns true if object was found
        return found;
    }

    // Method to get array of all elements in bag
    public T[] toArray() {
        // Creates response array
        T[] responseArray = (T[]) new Object[numberOfEntries];
        // Copies bag array to response array
        System.arraycopy(bag, 0, responseArray, 0,
                numberOfEntries);
        // Returns response array
        return responseArray;
    }
    
    // Method to display array elements from specified start to specified end
    private void displayArray(int start, int end, String prefix) {
        // Displays first element
        System.out.println(prefix + bag[start]);
        // If more elements, display array starting from next element
        if (start < end) displayArray(start + 1, end, prefix);
    }
    
    // Method to display all elements in bag
    public void display(String prefix) {
        // Call display array for all elements
        displayArray(0, numberOfEntries - 1, prefix);
    }
    
    // Method to get object as readable string
    public String toString() {
        // Creates response string
        String response = "Bag[";
        // Runs for every element in bag array
        for (int i = 0; i < numberOfEntries; i++) response += bag[i] + " ";
        // Closes response string
        response += "]";
        // Returns response string
        return response;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Declares bags
        ArrayBag<String> bagOfNames = new ArrayBag<String>(5);
        
        // Adds names to name bag
        System.out.println("Adding Adrian... " + 
                bagOfNames.addNewEntry("Adrian"));
        System.out.println("Adding Mary... " +
                bagOfNames.addNewEntry("Mary"));
        System.out.println("Adding Zoe... " +
                bagOfNames.addNewEntry("Zoe"));
        
        // Gets array of names in name bag
        Object[] arrayOfNames = bagOfNames.toArray();
        // Outputs each name
        for (Object name : arrayOfNames) System.out.print(name + "...");
        // Goes to next line
        System.out.println();


        // Adds more names to name bag
        System.out.println("Adding John... " +
                bagOfNames.addNewEntry("John"));
        System.out.println("Adding Siobhan... " +
                bagOfNames.addNewEntry("Siobhan"));
        System.out.println("Adding Patrick... " +
                bagOfNames.addNewEntry("Patrick"));

        // Gets array of names in name bag
        Object[] arrayOfNames2 = bagOfNames.toArray();
        // Outputs each name
        for (Object name : arrayOfNames2) System.out.print(name + "...");
        // Goes to next bag
        System.out.println();
    }
}
