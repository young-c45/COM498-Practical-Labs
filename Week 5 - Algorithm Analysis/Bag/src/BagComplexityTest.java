/*
 * BagComplexityTest Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 25/10/2022
 */

import java.util.Random;

// Template for BagComplexityTest objects
public class BagComplexityTest {
    // Sets the number of runs to perform
    private static final int NUM_OF_RUNS = 5;

    // Method to run on compile
    public static void main(String[] args) {
        // Creates the linked bag object
        LinkedBag<Integer> bag = new LinkedBag<>();
        // Creates random for random number generation
        Random random = new Random();
        
        // Declares needed variables
        long startTime, endTime;
        long[][] timings = new long[NUM_OF_RUNS][5];
        int numOfItems, maxItemValue, itemValue;
        boolean firstRow;
        String valueStr;
        
        // Runs for amount of runs set
        for (int i = 0; i < NUM_OF_RUNS; i++) {
            // Calculates the number of items to test (10^(i+1))
            numOfItems = (int) Math.pow(10, i+1);
            // Stores number of items in timings array
            timings[i][0] = numOfItems;
            // Calculates maximum item value
            maxItemValue = numOfItems * 10;
            
            // Runs for every item
            for (int j = 0; j < numOfItems; j++) {
                // Generates new item value to add
                itemValue = random.nextInt(maxItemValue);
                // Starts timer
                startTime = System.nanoTime();
                // Adds item
                bag.addNewEntry(itemValue);
                // Ends timer
                endTime = System.nanoTime();
                // Adds time to total add time in timings array
                timings[i][1] += endTime - startTime;
            }
            
            // Calculates average add time and stores in timings array
            timings[i][2] = timings[i][1] / numOfItems;
            
            // Runs for the amount of items in bag
            for (int j = 0; j < numOfItems; j++) {
                // Generates item value to try to remove
                itemValue = random.nextInt(maxItemValue);
                // Starts timer
                startTime = System.nanoTime();
                // Adds item
                bag.remove(itemValue);
                // Ends timer
                endTime = System.nanoTime();
                // Adds time to total remove time in timings array
                timings[i][3] += endTime - startTime;
            }

            // Calculates average remove time and stores in timings array
            timings[i][4] = timings[i][3] / numOfItems;
            
            // Empties bag
            bag.clear();
        }

        // Outputs formatting for timings table
        System.out.println("            Bag Size\t\t   Total Time to Add" +
                "\t\t     Avg Time to Add\t\tTotal Time to Remove" +
                "\t\t  Avg Time to Remove");
        // Runs for every array in timings array
        for (long[] values : timings) {
            // Sets adding first row
            firstRow = true;
            // Runs for every value in values array
            for (long valueLong : values) {
                // Converts value to string
                valueStr = "" + valueLong;
                // Runs until string is 20 characters long
                while (valueStr.length() < 20) {
                    // Adds space to start of string
                    valueStr = " " + valueStr;
                }
                // If adding first, set not adding first row for next iteration
                if (firstRow) firstRow = false;
                    // If not adding first row, add tab to start of string
                else valueStr = "\t\t" + valueStr;
                // Output value to console
                System.out.print(valueStr);
            }
            // Moves to next line
            System.out.println();
        }
    }
}
