/*
 * ArrayBag Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 03/10/2022
 */

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
    
    // Method to get size of bag
    public int getCurrentSize() {
        return 0;
    }

    // Method to get if bag is empty
    public boolean isEmpty() {
        return false;
    }

    // Method to add element to bag
    public boolean addNewEntry() {
        return false;
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
        return null;
    }
}
