/*
 * StackInterface Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 10/10/2022
 */

// Template for StackInterface classes
public interface StackInterface<T> {
    // Declares method signatures
    public void push(T newEntry);
    /*  
        Add a new entry to the top of the stack
        @param (T) newEntry - the entry to be added
     */
    
    public T pop();
    /*  
        Remove an entry from the top of the stack
        throw EmptyStackException if called on an empty stack
        @return (T) - the value that was on top of the stack
     */
    
    public T peek();
    /*  
        Return the entry from the top of the stack, but don't remove
        throw EmptyStackException if called on an empty stack
        @return (T) - the value at the top of the stack
     */
    
    public boolean isEmpty();
    /*  
        Return true if the stack is empty, false otherwise
        @return (boolean) - if the stack is empty
     */
    
    public void clear();
    /*  
        Remove all entries from the stack
     */
}
