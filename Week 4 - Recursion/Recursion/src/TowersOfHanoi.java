/*
 * TowersOfHanoi Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 17/10/2022
 */

import java.util.Scanner;

// Template for TowersOfHanoi objects
public class TowersOfHanoi {
    // Declares class variables
    private static final String SOURCE = "Source";
    private static final String SPARE = "Spare";
    private static final String TARGET = "Target";
    
    // Method to solve Towers of Hanoi puzzle without towers specified
    private static void solveTowers(int numOfDiscs) {
        // Runs solve method with tower names
        solveTowers(numOfDiscs, SOURCE, SPARE, TARGET);
    }
    
    // Method to solve Towers of Hanoi puzzle with towers specified
    private static void solveTowers(int numOfDiscs, String source,
                                   String spare, String target) {
        // If only 1 disc, moves source to target
        if (numOfDiscs == 1) System.out.println(source + " => " + target);
        // Runs otherwise
        else {
            // Solves for 1 less disc to spare
            solveTowers(numOfDiscs - 1, source, target, spare);
            // Moves source to target
            System.out.println(source + " => " + target);
            // Solves for 1 less disc from spare to target
            solveTowers(numOfDiscs - 1, spare, source, target);
        }
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Creates scanner for input
        Scanner input = new Scanner(System.in);
        // Get number of disks required
        System.out.println("Please enter the number of discs...");
        int numOfDiscs = input.nextInt();
        input.nextLine();
        // Solves Towers of Hanoi puzzle for number of towers
        solveTowers(numOfDiscs);
    }
}
