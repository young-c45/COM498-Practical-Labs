import java.util.Scanner;

/**
 * Lab Session 2
 * LongestCommonSubsequence class is a program that will determine the longest 
 * string that is a subsequence of two stings input by the user (in the
 * command line). The program applies a brute force solution to finding the 
 * subsequence. Uses the ArrayBag class for the Bag implementation.
 */

public class LongestCommonSubsequence {


    public static void main(String args[]) {

        BagInterface<String> testBag = null;
        String strBestSubsequence = null;

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("------------------------------------------------" + 
                        "-------------------------------------");
        System.out.println("This program determines the longest string that" + 
                " is a subsequence of two input strings.");
        System.out.println("Please enter the first string:");
        String strFirst = input.next();

        System.out.println("Please enter the second string:");
        String strSecond = input.next();
        System.out.println("\n");

        // Creates bag
        testBag = new ArrayBag<String>();
        // Adds input string to bag
        testBag.addNewEntry(strFirst);
        
        // Print out the current contents of the bag:
        System.out.println("The strings to check are: " + testBag);

        // Assign the empty string to the longest match subsequence:
        strBestSubsequence = new String("");


        // Loop to check the strings in the Bag:
        while (testBag.getCurrentSize() > 0) {

            // Takes the last string out of the bag to test
            String strTest = testBag.remove();
            System.out.println("Now checking: " + strTest);

            // If longest match is shorter than test string:
            if (strTest.length() > strBestSubsequence.length()) {

                // Runs if test string is a subsequence of second input string
                if (isSubsequence(strTest, strSecond)) {
                    
                    // Sets longest match to test string
                    strBestSubsequence = strTest;

                    System.out.println("Found a subsequence");

                } else {

                    // If the test string is at least two longer than the 
                    // longest match:
                    if (strTest.length() - 1 > strBestSubsequence.length()) {

                        // Runs for all characters in test string
                        for (int i = 0; i < strTest.length(); i++) {
                            // Creates smaller test string
                            String strNew = strTest.substring(0, i) +
                                    strTest.substring(i + 1);
                            // Adds new string to bag
                            testBag.addNewEntry(strNew);
                        }

                    }

                }
            }

            // Print the bag of strings to check:
            System.out.println("The bag of new strings to check is now: " +
                    testBag);
            System.out.println("Size: " + testBag.getCurrentSize());
            System.out.println();

        }

        // Print the longest match:
        System.out.println("Found " + strBestSubsequence + " for the longest" + 
                " common subsequence");
        System.out.println("------------------------------------------------" + 
                "-------------------------------------");

    }

    /**
     * Method to determine if one string is a subsequence of the other.
     * @param strCheck See if this is a subsequence of the other argument.
     * @param strAgainst The string to check against.
     * @return     A boolean if check is a subsequence of other.
     */
    public static boolean isSubsequence(String strCheck, String strAgainst) {

        boolean bResult = false;

        // Check if a subsequence exists
        // Only check if it is no longer than the against string:
        if (strCheck.length() <= strAgainst.length()) {
            int i = 0;
            for (int j = 0; i < strCheck.length() && j < strAgainst.length(); 
                 j++) {
                if (strCheck.charAt(i) == strAgainst.charAt(j)) {
                    i++;
                }
            }
            bResult = (i == strCheck.length());
        }
        return bResult;
    }
}
