/*
 * Stack Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 10/10/2022
 */

import java.util.EmptyStackException;

// Template for Stack objects
public class Stack<T> implements StackInterface<T> {
    // Declares instance variables
    private MyNode<T> topNode;
    
    // Default constructor
    public Stack() {
        // Sets instance variables
        topNode = null;
    }
    
    // Method to add entry to stack
    public void push(T newEntry) {
        // Creates node from specified value
        MyNode<T> newNode = new MyNode<>(newEntry);
        // Sets the new node to point to the current top node
        newNode.setNext(topNode);
        // Sets top node to new node
        topNode = newNode;
    }

    // Method to remove entry from stack
    public T pop() {
        // Get data from top node
        T dataToReturn = peek();
        // Set top node to next node, removing top node
        topNode = topNode.getNext();
        // Return data from removed node
        return dataToReturn;
    }

    // Method to get entry at top of stack without removal
    public T peek() {
        // Throws error if top node does not exist
        if (topNode == null) throw new EmptyStackException();
        // If top node exists, returns it's data
        else return topNode.getData();
    }

    // Method to get if stack is empty
    public boolean isEmpty() {
        // Returns true if top node is empty
        return (topNode == null);
    }

    // Method to clear stack
    public void clear() {
        // Removes the top node, clearing the list
        topNode = null;
    }

    // Method to run on compile
    public static void main(String[] args) {
        // Creates stack
        Stack<Integer> stack = new Stack<>();
        
        // Pushes entries onto stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Runs 4 times
        for (int i = 0; i < 4; i++) {
            try {
                // Outputs entry at top of stack
                System.out.println("Peek: " + stack.peek());
                // Removes entry at top of stack and outputs removed entry
                System.out.println("Pop: " + stack.pop());
            }
            // Runs if empty stack exception
            catch (EmptyStackException e) {
                // Outputs that there was an exception
                System.out.println("Exception!");
            }
        }

        // Pushes more entries onto stack
        stack.push(4);
        stack.push(5);
        stack.push(6);
        
        // Outputs if stack is empty
        System.out.println("Stack empty is " + stack.isEmpty());
        
        // Clears stack
        stack.clear();
        // Outputs if stack is empty
        System.out.println("Stack empty is " + stack.isEmpty());
    }
}
