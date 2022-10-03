/*
 * ArrayBag Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 03/10/2022
 */

import java.lang.reflect.Array;

// Template for ArrayBag objects
public class ArrayBag<T> implements BagInterface<T> {
    // Declares class variables
    private static final int DEFAULT_CAPACITY = 25;
    
    // Declares instance variables
    private T[] bag;
    private int numberOfEntries;
    
    // Default constructor
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }
    
    // Constructor with capacity passed
    public ArrayBag(int capacity) {
        // Creates the bag array
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
        // Sets the number of entries to none
        numberOfEntries = 0;
    }
    
    // Method to get if array is full
    private boolean isArrayFull() {
        // Returns true if no more entries can fit in the bag
        return (bag.length <= numberOfEntries);
    }
    
    // Method to get size of bag
    public int getCurrentSize() {
        return 0;
    }

    // Method to get if bag is empty
    public boolean isEmpty() {
        return false;
    }

    // Method to add element to bag
    public boolean addNewEntry(T anEntry) {
        // Fails if array is full
        if (isArrayFull()) return false;
        // Runs if array is not full
        else {
            // Adds the entry, then increments number of entries
            bag[numberOfEntries++] = anEntry;
            // Returns indicating success
            return true;
        }
    }

    // Method to remove last element from bag
    public T remove() {
        return null;
    }

    // Method to remove specific element from bag
    public boolean remove(T anEntry) {
        return false;
    }

    // Method to remove all elements from bag
    public void clear() {
        
    }

    // Method to get frequency of element in bag
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    // Method to get if element is in bag
    public boolean contains(T anEntry) {
        return false;
    }

    // Method to get array of all elements in bag
    public T[] toArray() {
        // Creates the response array
        T[] responseArray = (T[]) new Object[numberOfEntries];
        // Copies the bad array to the response array
        System.arraycopy(bag, 0, responseArray, 0,
                numberOfEntries);
        // Returns the response array
        return responseArray;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Declares bags
        ArrayBag<String> bagOfNames = new ArrayBag<String>(5);
        
        // Adds names to the name bag
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
        // Goes to the next line
        System.out.println();


        // Adds more names to the name bag
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
        // Outputs blank line for formatting
        System.out.println();
    }
}
