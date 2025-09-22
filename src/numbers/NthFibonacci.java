package numbers;

import java.util.Scanner;

/*
 * Program to find the Nth Fibonacci number
 * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 * The Nth Fibonacci number is the sum of the (N-1)th and (N-2)th Fibonacci numbers
 */

public class NthFibonacci {
    
    public static void main(String[] args) {
        
        // Input from user for Nth term
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Nth term Fibonacci you need to find: ");
        int number = sc.nextInt();  // index of the Fibonacci number to find

        int first = 0, second = 1;   // first two Fibonacci numbers

        // Handling edge cases
        if(number < 1){
            System.out.println("Invalid input. Please enter a number >= 1.");
            sc.close();
            return;
        }

        // If the user wants the 1st number
        else if(number == 1){
            System.out.println("The 1st Fibonacci number is: " + first);
            sc.close();
            return;
        }

        int result = 0;  // variable to store the Nth Fibonacci number

        // Loop to calculate Fibonacci numbers up to the Nth term
        for(int counter = 2; counter <= number; counter++){
            result = first + second;  // calculating next Fibonacci number

            first = second;   // updating first to the next number in the sequence
            second = result;   // updating second to the next number in the sequence
        }

        // Output the Nth Fibonacci number
        System.out.println("The " + number + "th Fibonacci number is: " + result);


        sc.close();
    }
}
