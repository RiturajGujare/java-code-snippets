package strings;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the bracket string: ");
        String input = sc.nextLine();

        boolean returnValue = checkBalance(input);
        System.out.println((returnValue)? "Balanced bracket string" : "Not a balanced bracket string");

        sc.close();
    }

    public static boolean checkBalance(String input){

        Stack<Character> characterStack = new Stack<>();

        for(char ch: input.toCharArray()){
            if(ch == '(' || ch =='[' || ch == '{'){
                characterStack.push(ch);
            }

            else{

                if(characterStack.isEmpty()) return false;

                char top = characterStack.pop();
                if( (ch == ')' && top != '(')
                || (ch == ']' && top != '[')
                || (ch == '}' && top != '{')
                ) {
                    return false;
                }   

            }
        }

        return characterStack.isEmpty();
    } 
}
