/*
 * Cardball Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 15/11/2022
 */

// Template for Cardball objects
public class Cardball {
    // Declares static variables
    private static final int NUMCARDS = 5;
    
    // Declares instance variables
    private Card[] player1 = new Card[NUMCARDS];
    private Card[] player2 = new Card[NUMCARDS];
    private int score1 = 0, score2 = 0;
    
    // Default constructor
    public Cardball() {
        // Creates the new deck
        Deck deck = new Deck();
        
        // Runs for each card in hand
        for (int i = 0; i < NUMCARDS; i++) {
            this.player1[i] = deck.deal();
            this.player2[i] = deck.deal();
        }
        
        // Sorts game hands
        sort(player1);
        sort(player1);
    }
    
    // Method to sort a hand
    private static <T extends Comparable <T>>void sort(T[] arr) {
        // Declare needed variables
        T nextToInsert;
        int index;
        
        // Runs for every card in array
        for (int i = 1; i < arr.length; i++) {
            // Stores card to sort
            nextToInsert = arr[i];
            
            // Sets array position to sort from
            index = i - 1;
            // Runs until correct position found
            while (index >= 0 && arr[index].compareTo(nextToInsert) > 0) {
                // Moves index position
                arr[index+1] = arr[index];
                index--;
            }
            // Moves card to correct position
            arr[index+1] = nextToInsert;
        }
    }

    // Method to run on compile
    public static void main(String[] args) {
        // Creates the game
        Cardball game = new Cardball();
        
        // Runs for each card
        for (int i = NUMCARDS - 1; i >= 0; i--) {
            // Outputs player's card
            System.out.println("Player 1: " + game.player1[i]);
            System.out.println("Player 2: " + game.player2[i]);
            
            // Decides who gets the goal
            if (game.player1[i].compareTo(game.player2[i]) > 0) {
                System.out.println("Goal to player 1\n");
                game.score1++;
            } else if (game.player1[i].compareTo(game.player2[i]) < 0) {
                System.out.println("Goal to player 2\n");
                game.score2++;
            } else System.out.println("No score\n");
        }
        
        // Outputs the final score
        System.out.println("FINAL SCORE");
        System.out.println("-----------");
        System.out.println("Player 1: " + game.score1);
        System.out.println("Player 2: " + game.score2);
    }
}
