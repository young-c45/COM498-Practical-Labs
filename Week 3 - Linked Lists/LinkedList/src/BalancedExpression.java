/*
 * BalancedExpression Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 10/10/2022
 */

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

// Template for BalancedExpression objects
public class BalancedExpression {
    // Method to get if expression is balanced
    private static boolean isBalanced(String expression) {
        // Declares needed variables
        char nextChar, openDelimiter;
        Stack<Character> stack = new Stack<>();
        
        // Runs until expression has no more characters
        while (expression.length() > 0) {
            // Gets the next character
            nextChar = expression.charAt(0);
            // Runs code based on character
            switch (nextChar) {
                // Runs if character is opening delimiter
                case '(':
                case '[':
                case '{':
                    // Pushes character onto stack
                    stack.push(nextChar);
                    // Marks code end
                    break;
                // Runs if character is closing delimiter 
                case ')':
                case ']':
                case '}':
                    // Exits indicating failure if stack is empty
                    if (stack.isEmpty()) return false;
                    // Runs if stack not empty
                    else {
                        // Gets and removes top stack value
                        openDelimiter = stack.pop();
                        // Exits indicating failure if not delimiter pair
                        if (openDelimiter == '(' && nextChar != ')' ||
                                openDelimiter == '[' && nextChar != ']' ||
                                openDelimiter == '{' && nextChar != '}')
                            return false;
                    }
            }
            // Removes character if expression has more characters
            if (expression.length() > 1) 
                expression = expression.substring(1);
            // If no more characters, set expression to empty string
            else expression = "";
        }
        // Exits indicating failure if stack not empty
        if (!stack.isEmpty()) return false;
        // Exits indicating success if no problems are found
        else return true;
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Creates new scanner input
        Scanner input = new Scanner(System.in);
        // Gets expression from user
        System.out.println("Enter an expression (no spaces)...");
        String expression = input.nextLine();
        // Outputs if expression balanced
        System.out.println(expression + "balanced? " + isBalanced(expression));
    }
}
