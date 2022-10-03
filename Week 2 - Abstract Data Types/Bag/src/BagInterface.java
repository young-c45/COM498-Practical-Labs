/*
 * BagInterface Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 03/10/2022
 */

// Template for BagInterface classes
public interface BagInterface<T> {
    // Declares method signatures
    public int getCurrentSize();
    /* The number of elements currently contained in the bag
    
    @return - (int) number of elements
     */
    
    public boolean isEmpty();
    /* Test for an empty bag
    
    @return - (boolean) true if the number of elements is zero, false otherwise
     */
    
    public boolean addNewEntry(T anEntry);
    /* Test for spare capacity in the bag. If there is, add the new
    element and increase the number of elements in the bag 
    
    @param (T) newEntry - the item to be added to the bag
    
    @return - (boolean) true if the item is added, false otherwise
     */
    
    public T remove();
    /* Remove any element from the bag, if one is available, and decrement the
    number of elements. Return the removed element, or null if none removed
    
    @return - (T) the element removed from the bag, or null
     */
    
    public boolean remove(T anEntry);
    /* Remove the specified element from the bag, if it is present, and 
    decrement the number of elements
    
    @return - (boolean) true if the element is removed, false otherwise
     */
    
    public void clear();
    /* Empty the bag - set the number of elements to zero
     */
    
    public int getFrequencyOf(T anEntry);
    /* Count how many times a given element appears in the bag
    
    @param (T) anEntry - the element to look for in the bag
    
    @return - (int) the number of times that the given element appears
     */
    
    public boolean contains(T anEntry);
    /* Check for the presence of a specified element in the bag
    
    @param (T) anEntry - the element to look for in the bag
    
    @return - (boolean) true if the bag contains the element, false otherwise
     */
    
    public T[] toArray();
    /* Find all elements in the bag
    
    @return - (T[]) an array of size number of elements, containing all the 
    contents of the bag 
     */
}
