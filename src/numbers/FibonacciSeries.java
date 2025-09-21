package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones,
 * usually starting with 0 and 1. That is, the sequence begins 0, 1, 1, 2, 3, 5, 8, 13, and so on.
 */
public class FibonacciSeries {
    
    public static void main(String[] args) {
        
        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = sc.nextInt();   //using nextInt() to read an integer input

        int first = 0, second = 1;   //initializing first two numbers of the series

        List<Integer> listOfFibonacciNumbers = new ArrayList<>();  //list to store the Fibonacci numbers

        // Handling edge cases for 0 and 1
        if(number == 0){
            System.out.println(listOfFibonacciNumbers);
            sc.close();
            return;
        }

        else if( number == 1){
            listOfFibonacciNumbers.add(first);   //adding only the first number (0) to the list
            System.out.println(listOfFibonacciNumbers);
            sc.close();
            return;
        }

        // Adding the first two numbers to the list
        listOfFibonacciNumbers.add(first);
        listOfFibonacciNumbers.add(second);

        // Generating Fibonacci numbers iteratively and adding them to the list
        for(int counter = 2; counter < number; counter++){    //starting from 2 as first two numbers are already added
            int result = first + second;   //calculating the next Fibonacci number
            listOfFibonacciNumbers.add(result);  //adding the new number to the list

            first = second;     //updating first and second for next iteration
            second = result;    //updating first and second for next iteration
        }

        // Displaying the list of Fibonacci numbers
        System.out.println("Fibonacci series up to " + number + " terms: " + listOfFibonacciNumbers);
        sc.close();
    }
}
