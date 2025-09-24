package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This program checks if a number is prime and finds all prime numbers up to a specified range.
 * It includes a method to determine if a number is prime and uses it to generate a list of prime numbers.
 */
public class PrimeNumber {
    
    public static void main(String[] args) {
        
        // Taking input from the user
        Scanner sc = new Scanner(System.in);

        // Checking if a number is prime
        System.out.println("Enter the prime you need to check: ");
        int number = sc.nextInt();

        // Calling the isPrime method to check if the number is prime
        boolean returnValue = isPrime(number);

        // Displaying the result
        System.out.println((returnValue) ? number + " is prime number" : number + " is not a prime number");


        // Finding all prime numbers up to a specified range
        System.out.println("Enter the range till which you need to find prime numbers: ");
        int range = sc.nextInt();

        // List to store prime numbers
        List<Integer> listOfprimeNumbers = new ArrayList<>();

        // Finding prime numbers in the specified range
        for(int i = 0; i <= range; i++){
            if(isPrime(i)){
                listOfprimeNumbers.add(i);  // adding the prime number to the list
            }
        }

        // Displaying the list of prime numbers using string join method which converts each integer to string and then joins them with a comma and space
        System.out.println("List of prime numbers till " + range + " are: " + String.join(", ", listOfprimeNumbers.stream()
                                                                                            .map(String::valueOf)
                                                                                            .toArray(String[]::new)));

        // Closing the scanner to prevent resource leaks                                                                                    
        sc.close();
    }

    public static boolean isPrime(int number){

        // A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
        // The only even prime number is 2. All other even numbers are not prime because they are divisible by 2.
        // To check if a number is prime, we can check for factors from 2 to the square root of the number.
        // If the number is divisible by any of these factors, it is not prime.
        if(number <= 1) return false;
        

        // Checking for factors from 2 to the square root of the number
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;  // number is divisible by i, hence not a prime number
            }
        }

        // If no factors were found, the number is prime
        return true;
    }
}
