/*
 * Deck Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 15/11/2022
 */

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

// Template for Deck objects
public class Deck {
    // Declares static variables
    private static final int NUMCARDS = 52;
    
    // Declares instance variables
    private final Card[] CARDS = new Card[52];
    private int cardIndex;
    
    // Default constructor
    public Deck() {
        // Runs for every card
        for (int thisCard = 0; thisCard < NUMCARDS; thisCard++) {
            // Adds a new card to the deck
            this.CARDS[thisCard] = new Card(thisCard % 13, thisCard / 13);
        }
        // Sets the card index
        this.cardIndex = NUMCARDS - 1;
        // Shuffles the deck
        this.shuffle();
    }
    
    // Method to shuffle the deck
    private void shuffle() {
        // Declares needed variables
        int index;
        Card temp;
        
        // Creates object to generate random numbers
        Random random = new Random();
        // Runs for every card
        for (int i = this.CARDS.length - 1; i > 0; i--) {
            // Generates a random index for the card
            index = random.nextInt(i + 1);
            // Stores the card to be replaced
            temp = this.CARDS[index];
            // Moves the cards to new positions
            this.CARDS[index] = this.CARDS[i];
            this.CARDS[i] = temp;
        }
    }
    
    // Method to deal a card
    public Card deal() {
        return this.CARDS[this.cardIndex--];
    }
}
