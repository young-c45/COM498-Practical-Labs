/*
 * Snap Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 10/11/2022
 */

// Template for Snap objects
public class Snap {
    // Method to play a game of snap
    public static void playGame(int numOfCards) {
        // Declares needed variables
        int snaps = 0, supersnaps = 0;
        Card currentCard, lastCard = null;
        
        // Runs for the number of cards specified
        for (int i = 0; i < numOfCards; i++) {
            // Generates a new card
            currentCard = new Card();
            // Outputs card information
            System.out.println("Pulled a " + currentCard);
            
            // Runs if card means snap
            if (lastCard != null && currentCard.compareTo(lastCard) == 0) {
                // Adds to number of snaps
                snaps++;
                // Runs if cards have same suit
                if (currentCard.getSuit().equals(lastCard.getSuit())) {
                    // Outputs that it's a supersnap
                    System.out.println("SUPERSNAP!!!");
                    // Adds to number of supersnaps
                    supersnaps++;
                }
                // Outputs that it's a snap if cards have different suits
                else System.out.println("SNAP!!!");
            }
            
            // Stores current card as last card
            lastCard = currentCard;
        }
        
        // Outputs number of snaps and supersnaps
        System.out.println("\nThere were " + snaps + " snaps, including " 
                + supersnaps + " supersnaps.");
    }

    // Method to run on compile
    public static void main(String[] args) {
        // Plays a game of snap
        playGame(100);
    }
}
