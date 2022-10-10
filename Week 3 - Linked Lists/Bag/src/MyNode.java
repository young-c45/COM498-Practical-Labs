/*
 * MyNode Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 10/10/2022
 */

// Template for MyNode objects
public class MyNode<T> {
    // Declares instance variables
    private T data;
    private MyNode<T> next;
    
    // Default constructor
    public MyNode(T dataValue) {
        // Sets instance variables
        data = dataValue;
        next = null;
    }
    
    // Method to get data in node
    public T getData() {
        // Returns data
        return data;
    }
    
    // Method to set the data in node
    public void setData(T newData) {
        // Sets data
        data = newData;
    }
    
    // Method to get next node
    public MyNode<T> getNext() {
        // Returns next node
        return next;
    }
    
    // Method to set next node in list
    public void setNext(MyNode<T> newNext) {
        // Sets next
        next = newNext;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Creates nodes
        MyNode<Integer> node1 = new MyNode<Integer>(1);
        MyNode<Integer> node2 = new MyNode<Integer>(2);
        MyNode<Integer> node3 = new MyNode<Integer>(3);
        
        // Links nodes together
        node1.setNext(node2);
        node2.setNext(node3);
        
        // Outputs stored values in nodes
        System.out.println("Value of node1 is " + node1.getData());
        System.out.println("Value of node2 is " + node1.getNext().getData());
        System.out.println("Value of node3 is " + 
                node1.getNext().getNext().getData());
    }
}
