/*
 * LinkedBag Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 10/10/2022
 */

// Template for LinkedBag objects
public final class LinkedBag<T> implements BagInterface<T> {
    // Declares instance variables
    private MyNode<T> firstNode;
    private int numberOfEntries;
    
    // Default constructor
    public LinkedBag() {
        // Sets instance variables
        firstNode = null;
        numberOfEntries = 0;
    }
    
    // Method to get node with specified value from bag
    private MyNode<T> findEntry(T anEntry) {
        // Declares variable for current node, and set's it to first node
        MyNode<T> currentNode = firstNode;
        // Runs until no more nodes in list
        while (currentNode != null) {
            // Returns current node if it's value of is specified value
            if (currentNode.getData().equals(anEntry)) return currentNode;
            // If not correct value, move to next node
            else currentNode = currentNode.getNext();
        }
        // Returns null if no node found
        return null;
    }
    
    // Gets current size of bag
    public int getCurrentSize() {
        // Returns number of entries in bag
        return numberOfEntries;
    }

    // Gets if bag is empty
    public boolean isEmpty() {
        // Returns true if number of entries is 0
        return (numberOfEntries == 0);
    }

    // Adds new entry to bag
    public boolean addNewEntry(T anEntry) {
        // Creates new node
        MyNode<T> newNode = new MyNode<>(anEntry);
        // Sets new node to point to first node in list
        newNode.setNext(firstNode);
        // Sets new node to first node
        firstNode = newNode;
        // Increment number of entries
        numberOfEntries++;
        // Exits indicating success
        return true;
    }

    // Removes entry from bag
    public T remove() {
        // Runs if list has entries
        if (firstNode != null) {
            // Gets copy of data in first node
            T response = firstNode.getData();
            // Sets first node to next node, removing first node
            firstNode = firstNode.getNext();
            // Decrement number of entries
            numberOfEntries--;
            // Returns removed value
            return response;
        }
        // Returns null if no entries in list
        else return null;
    }

    // Removes specified entry from bag
    public boolean remove(T anEntry) {
        // Create node to remove
        MyNode<T> nodeToRemove = findEntry(anEntry);
        // Exits indicating failure if no node to remove
        if (nodeToRemove == null) return false;
        // Sets node to removes data to that at first node
        nodeToRemove.setData(firstNode.getData());
        // Sets first node to next node, removing first node
        firstNode = firstNode.getNext();
        // Decrement number of entries
        numberOfEntries--;
        // Exits indicating success
        return true;
    }

    // Empties bag
    public void clear() {
        // Clears first node
        firstNode = null;
        // Sets number of entries to none
        numberOfEntries = 0;
    }

    // Gets frequency of specified entry in bag
    public int getFrequencyOf(T anEntry) {
        // Declares variable to store count of specified entry
        int count = 0;
        // Declares variable for current node, and set's it to first node
        MyNode<T> currentNode = firstNode;
        // Runs until no more nodes in list
        while (currentNode != null) {
            // Increments count if current node is specified entry
            if (currentNode.getData().equals(anEntry)) count++;
            // Sets current node to next node in list
            currentNode = currentNode.getNext();
        }
        // Returns count of specified entry
        return count;
    }

    // Gets if bag contains specified entry
    public boolean contains(T anEntry) {
        // Declares variable for current node, and set's it to first node
        MyNode<T> currentNode = firstNode;
        // Runs until no more nodes in list
        while (currentNode != null) {
            // Exits indicating success if current node is specified entry
            if (currentNode.getData().equals(anEntry)) return true;
            // If not correct value, move to next node
            else currentNode = currentNode.getNext();
        }
        // Exits indicating failure
        return false;
    }

    // Converts bag to array
    public T[] toArray() {
        // Declares needed variables
        T[] resultArray = (T[]) new Object[numberOfEntries];
        int index = 0;
        MyNode<T> currentNode = firstNode;
        
        // Runs until no more nodes in list
        while (currentNode != null) {
            // Adds value of current node to array and increments index
            resultArray[index++] = currentNode.getData();
            // Moves to next node
            currentNode = currentNode.getNext();
        }
        
        // Returns resulting array
        return resultArray;
    }
    
    // Method to return bag as readable string
    public String toString() {
        // Declares needed variables
        MyNode<T> currentNode = firstNode;
        String result = "Bag[ ";
        
        // Runs until no more nodes in list
        while (currentNode != null) {
            // Adds node data to string
            result += currentNode.getData() + " ";
            // Moves to next node
            currentNode = currentNode.getNext();
        }
        
        // Returns resulting string
        return result + "]";
    }
}
