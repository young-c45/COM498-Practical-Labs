/*
 * PQueue Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 12/10/2022
 */

import java.util.Random;

// Template for PQueue objects
public class PQueue<T extends Comparable <T>> implements PQueueInterface<T> {
    // Declares instance variables
    private MyNode<T> front;

    // Default constructor
    public PQueue() {
        // Sets instance variables
        front = null;
    }

    // Method to add entry to queue
    public void enqueue(T newEntry) {
        // Creates entry node
        MyNode<T> newNode = new MyNode<>(newEntry);
        // Declares next and current node
        MyNode<T> nextNode, currentNode = front;
        
        // If queue empty set new node to front
        if (currentNode == null) front = newNode;
        // Runs if queue not empty and front lower priority
        else if (currentNode.getData().compareTo(newNode.getData()) <= 0) {
            // Points new node to current node
            newNode.setNext(currentNode);
            // Sets new node to front
            front = newNode;
        }
        // Runs if queue not empty and front higher priority 
        else {
            // Gets next node
            nextNode = currentNode.getNext();
            // Runs until no more nodes in queue or next node higher priority
            while (nextNode != null &&
                    nextNode.getData().compareTo(newNode.getData()) >= 0) {
                // Moves to next node
                currentNode = nextNode;
                nextNode = nextNode.getNext();
            }
            
            // Points new node to next node
            newNode.setNext(nextNode);
            // Points current node to new node
            currentNode.setNext(newNode);
        }
    }
    
    // Method to remove entry from queue
    public T dequeue() {
        // Declares variable to return
        T response = null;

        // Runs if queue isn't empty
        if (front != null) {
            // Gets data from entry to remove
            response = front.getData();
            // Sets front to next entry, removing entry at front
            front = front.getNext();
        }

        // Return the result
        return response;
    }

    // Method to get front entry in queue without removing it
    public T getFront() {
        // Declares variable to return
        T response = null;

        // Gets data from entry at front if queue isn't empty
        if (front != null) response = front.getData();

        // Return the result
        return response;
    }

    // Method to check if queue is empty
    public boolean isEmpty() {
        // Return true if no entries in queue
        return (front == null);
    }

    // Method to clear queue
    public void clear() {
        // Removes entries from queue
        front = null;
    }

    // Method to run on compile
    public static void main(String[] args) {
        // Declares needed variables
        int numOfEntries = 10, entryData;
        Random random = new Random();
        // Declares new priority queue
        PQueue<Integer> intPQueue = new PQueue<>();
        
        // Runs for all entries
        for (int i=0; i < numOfEntries; i++) {
            // Generates the entry
            entryData = random.nextInt(1000) + 1;
            // Outputs entry info
            System.out.println("Adding value: " + entryData);
            // Adds entry to queue
            intPQueue.enqueue(entryData);
        }
        
        // Outputs formatting line
        System.out.println("--------------------");
        
        // Runs for all items in queue
        while (!intPQueue.isEmpty()) {
            // Outputs and removes next in queue
            System.out.println("Removing value: " + intPQueue.dequeue());
        }
    }
}
