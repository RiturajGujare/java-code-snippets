package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This program finds all Armstrong numbers within a specified range (from 0 to a given number).
 * An Armstrong number (or narcissistic number) is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
 * For example, 153 is an Armstrong number because it has 3 digits, and 1^3 + 5^3 + 3^3 = 153.
 * Similarly, 9474 is an Armstrong number because it has 4 digits, and 9^4 + 4^4 + 7^4 + 4^4 = 9474.        
 */

public class ArmstrongNumbersInRange {
    
    public static void main(String[] args) {

        // Taking input from the user for the upper limit of the range
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number till which you need to find the armstrong number: ");
        int numberTillRange = sc.nextInt();  // upper limit of the range
        List<Integer> listOfArmstrongNumbers = new ArrayList<>();  // list to store Armstrong numbers

        // Looping through all numbers from 0 to the specified limit and checking if they are Armstrong numbers
        for(int i = 0; i <= numberTillRange; i++){
            int returnValue = ArmstrongNumber.checkArmstrong(i);
            if(returnValue == 1){   // if the number is an Armstrong number, add it to the list
                listOfArmstrongNumbers.add(i);
            }
        }

        // Output the list of Armstrong numbers found within the specified range
        System.out.println("List of Armstrong numbers till " + numberTillRange + " is: " + listOfArmstrongNumbers);

        // Closing the scanner object to prevent resource leaks
        sc.close();
    }

    public static int checkArmstrong(int number){

        int originalNumber = number;  // storing the original number for later comparison
        int lengthOfNumber = String.valueOf(Math.abs(number)).length();  // calculating the number of digits in the number
        int sum = 0;  // variable to store the sum of the digits raised to the power of lengthOfNumber

        // Loop to extract each digit, raise it to the power of lengthOfNumber, and add it to the sum
        while (number > 0) {
            int modulus = number % 10;   // extracting the last digit of the number
            double modulusValueAfterPower = Math.pow(modulus, lengthOfNumber);  // raising the digit to the power of lengthOfNumber

            sum = (int) (sum + modulusValueAfterPower);  // adding the result to the sum

            number = number / 10;  // removing the last digit from the number
        }

        // Returning 1 if the number is an Armstrong number, otherwise returning 0
        return ((sum == originalNumber) ? 1 : 0);
    }
}
