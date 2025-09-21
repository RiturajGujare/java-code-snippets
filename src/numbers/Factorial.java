package numbers;

import java.util.Scanner;
import java.util.stream.IntStream;


/*
 * The factorial of a non-negative integer n is the product of all positive integers less than or equal to n.
 * It is denoted by n!.
 */
public class Factorial {
    
    public static void main(String[] args) {
        
        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find its factorial: ");
        int number = sc.nextInt();  //using nextInt() to read an integer input
        int numberCopy = number;    //numberCopy is used to preserve the original number

        // Factorial of negative numbers is not defined

        // Handling edge cases for 0! and 1!
        if(numberCopy == 1 || numberCopy == 0){
            System.out.println(1);
            sc.close(); // Closing the scanner to prevent resource leaks
            return;  // Exiting the program
        }

        // Calculating factorial using iterative approach
        int sum = 1;  //initializing sum to 1 as multiplying by 1 does not change the value

        //iteratively multiplying numbers from number down to 1
        while(numberCopy > 1){  
            sum = sum * numberCopy;  //logic for multiplication
            numberCopy--;    //decrementing numberCopy by 1 in each iteration
        }

        // Displaying the result using iterative approach
        System.out.println("Factorial of " + number + " is: " + sum);

        // Calculating factorial using Java Streams
        int factorial = IntStream.rangeClosed(1, number)  //creates a stream of integers from 1 to number (inclusive)
                        .reduce(1, (x, y) -> x * y);     //reduces the stream by multiplying all elements, starting with an initial value of 1

        // Displaying the result using streams 
        System.out.println("Factorial using streams: " + factorial);

        sc.close(); // Closing the scanner to prevent resource leaks
    }
}
