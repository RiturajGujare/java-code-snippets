package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArmstrongNumbersInRange {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number till which you need to find the armstrong number: ");
        int numberTillRange = sc.nextInt();
        List<Integer> listOfArmstrongNumbers = new ArrayList<>();

        for(int i = 0; i <= numberTillRange; i++){
            int returnValue = ArmstrongNumber.checkArmstrong(i);
            if(returnValue == 1){
                listOfArmstrongNumbers.add(i);
            }
        }

        System.out.println("List of Armstrong numbers till " + numberTillRange + " is: " + listOfArmstrongNumbers);

        sc.close();
    }

    public static int checkArmstrong(int number){

        int originalNumber = number;
        int lengthOfNumber = String.valueOf(Math.abs(number)).length();
        int sum = 0;

        while (number > 0) {
            int modulus = number % 10;
            double modulusValueAfterPower = Math.pow(modulus, lengthOfNumber);

            sum = (int) (sum + modulusValueAfterPower);

            number = number / 10;
        }

        return ((sum == originalNumber) ? 1 : 0);
    }
}
