/*
 * RankedCards Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 08/11/2022
 */

// Template for RankedCards objects
public class RankedCards {
    // Method to run on compile
    public static void main(String[] args) {
        // Declares needed variables
        Card myCards[] = new Card[10];
        int biggestValue = -1, biggestPos = -1;
        Card tempCard;
        
        // Creates all the cards
        for (int i = 0; i < myCards.length; i++) {
            // Constructs the card
            myCards[i] = new Card();
            // Sets biggest variables if new card has biggest value
            if (myCards[i].getRankValue() > biggestValue) {
                biggestValue = myCards[i].getRankValue();
                biggestPos = i;
            }
        }
        
        // Outputs all the cards
        System.out.println("myCards are...");
        for (int i = 0; i < myCards.length; i++) {
            System.out.println(myCards[i]);
        }
        // Outputs the position of the biggest card
        System.out.println("\nBiggest rank value is at position "
                + biggestPos);
        
        // Puts the biggest card to the end
        tempCard = myCards[9];
        myCards[9] = myCards[biggestPos];
        myCards[biggestPos] = tempCard;
        
        // Outputs all the cards after swapping
        System.out.println("After swapping...");
        for (int i = 0; i < myCards.length; i++) {
            System.out.println(myCards[i]);
        }
    }
}
