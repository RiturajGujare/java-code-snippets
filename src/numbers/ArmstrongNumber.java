package numbers;

import java.util.Scanner;

/*
 * An Armstrong number (or narcissistic number) is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
 * For example, 153 is an Armstrong number because it has 3 digits, and 1^3 + 5^3 + 3^3 = 153.
 * Similarly, 9474 is an Armstrong number because it has 4 digits, and 9^4 + 4^4 + 7^4 + 4^4 = 9474.    
 */
public class ArmstrongNumber {
    
    public static void main(String[] args) {
        
        // Taking input from the user for the number to check
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = sc.nextInt();  // number to check

        // Check if the number is an Armstrong number
        int returnValue = checkArmstrong(number);
        System.out.println(returnValue == 1 ? "Armstrong Number" : "Not Armstrong Number");

        // Closing the scanner object to prevent resource leaks
        sc.close();
    }


    // Function to check if a number is an Armstrong number
    public static int checkArmstrong(int number){

        int originalNumber = number;   // storing the original number for later comparison
        int lengthOfNumber = String.valueOf(Math.abs(number)).length();   // calculating the number of digits in the number
        int sum = 0;  // variable to store the sum of the digits raised to the power of lengthOfNumber

        while(number > 0){
            int modulusValue = number % 10;  // extracting the last digit of the number
            double modulusValueAfterPower = Math.pow(modulusValue, lengthOfNumber);  // raising the digit to the power of lengthOfNumber
            sum = (int) (sum + modulusValueAfterPower);  // adding the result to the sum    

            number = number / 10;  // removing the last digit from the number
        }

        // Comparing the sum with the original number to determine if it is an Armstrong number
        if(originalNumber == sum){
            return 1;
        }

        return 0;
    }
}
