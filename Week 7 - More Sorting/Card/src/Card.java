/*
 * Card Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 08/11/2022
 */

import java.util.Comparator;
import java.util.Random;
import java.util.random.RandomGenerator;

// Template for Card objects
public class Card implements Comparable<Card> {
    // Creates object to generate random numbers
    private static final Random GENERATOR = new Random();
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
        RANK = GENERATOR.nextInt(RANKS.length);
        SUIT = GENERATOR.nextInt(SUITS.length);
    }
    
    // Constructor with rank and suit provided
    public Card(int r, int s) {
        // Sets rank and suit of card
        RANK = r;
        SUIT = s;
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
    
    // Method to get number of card's rank
    public int getRankValue() {
        // Returns the rank value
        return RANK;
    }
    
    // Method to get card as a string
    @Override
    public String toString() {
        // Returns readable representation of card
        return getRank() + " of " + getSuit();
    }
    
    // Method to compare to other card
    @Override
    public int compareTo(Card otherCard) {
        // Returns 1 if rank more than other card
        if (this.getRankValue() > otherCard.getRankValue()) return 1;
        // Returns -1 if rank less than other card
        else if (this.getRankValue() < otherCard.getRankValue()) return -1;
        // Returns 0 if cards have same rank
        else return 0;
    }
}
