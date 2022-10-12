/*
 * PQueueInterface Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 12/10/2022
 */

// Template for PQueueInterface classes
public interface PQueueInterface<T> {
    // Declares method signatures
    public void enqueue(T newEntry);
    /*
        Add new entry to the queue in priority position
        @param (T) newEntry - the entry to be added
     */

    public T dequeue();
    /*
        Remove entry from the front of the queue
        @return (T) - the value that was at the front of the queue
     */

    public T getFront();
    /*
        Return, but don't remove, the entry from the front of the queue
        @return (T) - the value at the front of the stack
     */

    public boolean isEmpty();
    /*
        Return true if the queue is empty, false otherwise
        @return (boolean) - if the queue is empty
     */

    public void clear();
    /*
        Remove all entries from the queue
     */
}
