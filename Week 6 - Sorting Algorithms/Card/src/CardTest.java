/*
 * CardTest Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 08/11/2022
 */

// Template for CardTest objects
public class CardTest {
    // Method to run on compile
    public static void main(String[] args) {
        // Creates cards
        Card card1 = new Card();
        Card card2 = new Card();
        
        // Outputs info about cards
        System.out.println("Card 1 is the " + card1);
        System.out.println("Card 2 is the " + card2);
        
        // Outputs if cards are equal or which card is bigger
        if (card1.compareTo(card2) > 0) System.out.println("Card 1 is bigger");
        else if (card1.compareTo(card2) < 0) 
            System.out.println("Card 2 is bigger");
        else System.out.println("Card 1 and Card 2 are equal");
    }
}
