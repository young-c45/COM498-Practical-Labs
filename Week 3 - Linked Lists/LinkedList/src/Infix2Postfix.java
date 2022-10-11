/*
 * Infix2Postfix Class
 * Created by Callum Young
 * Student Num B00834218
 * File Created 11/10/2022
 */

import java.util.Scanner;

// Template for Infix2Postfix objects
public class Infix2Postfix {
    // Method to get precedence of operator
    public static int getPrecedence(char op) {
        // Declares precedence variable
        int precedence;
        
        // Sets precedence based on operator
        switch (op) {
            case '^':
                precedence = 3;
                break;
            case '/':
            case '*':
                precedence = 2;
                break;
            case '+':
            case '-':
                precedence = 1;
                break;
            default:
                precedence = 0;
                break;
        }
        
        // Returns operator precedence
        return precedence;
    }
    
    // Method to perform calculation using character operator
    public static int calculate(int num1, int num2, char operator) {
        // Performs calculation from operator, returns result
        switch (operator) {
            case '^':
                return (int) Math.round(Math.pow(num1, num2));
            case '/':
                return num1 / num2;
            case '*':
                return num1 * num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                throw new ArithmeticException();
        }
    }
    
    // Method to convert infix expression to postfix
    public static String infix2postfix(String infix) {
        // Declares needed variables
        String postfix = "";
        Stack<Character> opStack = new Stack<>();
        int currentOpPrecedence, compOpPrecedence;
        boolean done;
        char nextChar, compOp;
        
        // Runs until infix expression empty
        while (infix.length() > 0) {
            // Gets next character in infix expression
            nextChar = infix.charAt(0);
            // Runs code based on character
            switch (nextChar) {
                case '(':
                    // Pushes character onto stack
                    opStack.push(nextChar);
                    // Ends case
                    break;
                case ')':
                    // Sets not done
                    done = false;
                    // Runs until done
                    while (!done) {
                        // Gets operator from stack
                        compOp = opStack.pop();
                        // Sets done if operator is (
                        if (compOp == '(') done = true;
                        // Adds operator to postfix expression if not (
                        else postfix += compOp;
                    }
                    // Ends case
                    break;
                // Runs for everything else
                default:
                    // Gets character precedence
                    currentOpPrecedence = getPrecedence(nextChar);
                    // Adds character to postfix expression if not operator
                    if (currentOpPrecedence == 0) postfix += nextChar;
                    // Runs if character is operator
                    else {
                        // Sets not done
                        done = false;
                        // Runs until done
                        while (!done) {
                            // Runs if operator occurs before next in stack
                            if (opStack.isEmpty() || currentOpPrecedence > 
                                    getPrecedence(opStack.peek())) {
                                // Adds operator to stack
                                opStack.push(nextChar);
                                // Sets done
                                done = true;
                            }
                            // Adds next in stack to postfix if before op
                            else postfix += opStack.pop();
                        }
                    }
            }
            // Removes character if infix expression has more characters
            if (infix.length() > 1) infix = infix.substring(1);
            // If no more characters,  set infix expression to empty string
            else infix = "";
        }
        
        // Adds rest of stack to postfix expression
        while (!opStack.isEmpty()) postfix += opStack.pop();
        
        // Returns postfix expression
        return postfix;
    }
    
    // Method to calculate result of postfix expression
    public static int evaluatePostfix(String expression) {
        // Declares needed variables
        int result = 0, num1, num2;
        Stack<Integer> numStack = new Stack<>();
        char nextChar;

        // Runs until expression empty
        while (expression.length() > 0) {
            // Gets next character
            nextChar = expression.charAt(0);
            
            // Adds character to stack if digit
            if (Character.isDigit(nextChar)) 
                numStack.push(Character.getNumericValue(nextChar));
            // Runs if character is not digit
            else {
                // Gets 2 numbers
                num2 = numStack.pop();
                num1 = numStack.pop();
                
                // Pushes calculation result to stack
                numStack.push(calculate(num1, num2, nextChar));
            }
            
            // Removes character if expression has more characters
            if (expression.length() > 1)
                expression = expression.substring(1);
            // If no more characters, set expression to empty string
            else expression = "";
        }
        
        // Returns result
        return numStack.pop();
    }
    
    // Method to run on compile
    public static void main(String[] args) {
        // Declares needed variables
        Stack<Character> stack = new Stack<>();
        Scanner input = new Scanner(System.in);
        String infix, postfix;
        
        // Gets infix expression
        System.out.println("Enter an infix expression (no spaces)...");
        infix = input.nextLine();
        
        // Converts expression to postfix
        postfix = infix2postfix(infix);
        
        // Outputs postfix expression and result
        System.out.println("Postfix is " + postfix);
        System.out.println("Result is " + evaluatePostfix(postfix));
    }
}
