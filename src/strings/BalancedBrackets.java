package strings;

import java.util.Scanner;
import java.util.Stack;

/*
 * This program checks if a string of brackets is balanced using a Stack data structure.
 * It supports three types of brackets: (), {}, and []. 
 * Balanced brackets mean that each opening bracket has a corresponding closing bracket in the correct order.
 * eg: "({[]})" is balanced, while "({[})]" is not.
 */
public class BalancedBrackets {
    
    public static void main(String[] args) {
        
        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the bracket string: ");
        String input = sc.nextLine();

        // Checking if the bracket string is balanced
        boolean returnValue = checkBalance(input);

        // Displaying the result to the user
        System.out.println((returnValue)? "Balanced bracket string" : "Not a balanced bracket string");

        sc.close(); // closing the scanner object
    }

    public static boolean checkBalance(String input){

        // character stack to keep track of opening brackets
        Stack<Character> characterStack = new Stack<>();

        // Iterating through each character in the input string
        for(char ch: input.toCharArray()){

            // If the character is an opening bracket, push it onto the stack
            if(ch == '(' || ch =='[' || ch == '{'){
                characterStack.push(ch);
            }

            // If the character is a closing bracket, check for matching opening bracket
            else{

                // If stack is empty, it means there's no matching opening bracket
                if(characterStack.isEmpty()) return false;

                // Pop the top element from the stack and check if it matches the closing bracket
                char top = characterStack.pop();
                if( (ch == ')' && top != '(')
                || (ch == ']' && top != '[')
                || (ch == '}' && top != '{')
                ) {
                    return false;   // Mismatched brackets
                }   

            }
        }

        // If the stack is empty, all opening brackets had matching closing brackets.
        // instead of returing true here, we return if the stack is empty.
        return characterStack.isEmpty();
    } 
}
