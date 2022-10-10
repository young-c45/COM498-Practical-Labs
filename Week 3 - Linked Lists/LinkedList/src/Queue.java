/*
 * Queue Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 10/10/2022
 */

import java.util.EmptyStackException;

// Template for Queue objects
public class Queue<T> implements QueueInterface<T> {
    // Declares instance variables
    private MyNode<T> front, rear;
    
    // Default constructor
    public Queue() {
        // Sets instance variables
        front = null;
        rear = null;
    }
    
    // Method to add entry to queue
    public void enqueue(T newEntry) {
        // Creates new node from specified value
        MyNode<T> newNode = new MyNode<>(newEntry);
        // Puts new node to front if queue empty
        if (front == null) front = newNode;
        // Sets rear node to point to new node if queue not empty
        else rear.setNext(newNode);
        // Sets new node to rear
        rear = newNode;
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
            // Removes rear entry if queue now empty
            if (front == null) rear = null;
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
        rear = null;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Creates queue
        Queue<String> queue = new Queue<>();

        // Adds entries to the queue
        queue.enqueue("Milk");
        queue.enqueue("Eggs");
        queue.enqueue("Bread");

        // Runs 4 times
        for (int i = 0; i < 4; i++) {
            // Outputs entry at top of stack
            System.out.println("Get Front: " + queue.getFront());
            // Removes entry at top of stack and outputs removed entry
            System.out.println("Dequeue: " + queue.dequeue());
        }

        // Pushes more entries onto stack
        queue.enqueue("Cheese");
        queue.enqueue("Steak");
        queue.enqueue("Fish");

        // Outputs if stack is empty
        System.out.println("Queue empty is " + queue.isEmpty());

        // Clears stack
        queue.clear();
        // Outputs if stack is empty
        System.out.println("Queue empty is " + queue.isEmpty());
    }
}
