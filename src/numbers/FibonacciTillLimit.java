package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * this program generates the Fibonacci series up to a given limit.
 * The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones,
 * usually starting with 0 and 1. That is, the sequence begins 0, 1, 1, 2, 3, 5, 8, 13, and so on.  
 */
public class FibonacciTillLimit {
    
    public static void main(String[] args) {
        
        // Taking input from the user for the limit of the Fibonacci series
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number till which fibonaaci series you need to find: ");
        int number = sc.nextInt();  // limit for the Fibonacci series

        //list to store the Fibonacci numbers
        List<Integer> listOfFibonaaciNumbers = new ArrayList<>();
        int first = 0, second = 1; // initializing first two Fibonacci numbers
        int result = first + second;  // variable to store the next Fibonacci number

        listOfFibonaaciNumbers.add(first);  // adding the first Fibonacci number (0)
        listOfFibonaaciNumbers.add(second);  // adding the second Fibonacci number (1)

        //loop to generate Fibonacci numbers until the limit is reached
        while(result <= number) {
            listOfFibonaaciNumbers.add(result); // adding the next Fibonacci number to the list
            first = second;
            second = result;
            result = first + second;  // calculating the next Fibonacci number
        }
        
        // Output the Fibonacci series up to the given limit
        System.out.println("Fibonacci series till " + number + " is: " + listOfFibonaaciNumbers);
        sc.close();
    }
}
