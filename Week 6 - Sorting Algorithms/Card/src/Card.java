/*
 * Card Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 08/11/2022
 */

import java.util.Random;
import java.util.random.RandomGenerator;

// Template for Card objects
public class Card {
    // Creates object to generate random numbers
    private static final Random GENEORATOR = new Random();
    // Declares class variables
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8",
            "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", 
            "Spades"};
    
    // Declares instance variables
    private final int RANK, SUIT;
    
    // Default constructor
    public Card() {
        // Sets rank and suit of card
        RANK = GENEORATOR.nextInt(RANKS.length);
        SUIT = GENEORATOR.nextInt(SUITS.length);
    }
    
    // Method to get rank of card
    public String getRank() {
        // Returns card's rank
        return RANKS[RANK];
    }
    
    // Method to get suit of card
    public String getSuit() {
        // Returns card's suit
        return SUITS[SUIT];
    }
    
    // Method to get card as a string
    @Override
    public String toString() {
        // Returns readable representation of card
        return getRank() + " of " + getSuit();
    }
}
