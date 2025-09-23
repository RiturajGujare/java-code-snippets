package numbers;

import java.util.Scanner;

public class ArmstrongNumber {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = sc.nextInt();

        int returnValue = checkArmstrong(number);
        System.out.println(returnValue == 1 ? "Armstrong Number" : "Not Armstrong Number");

        sc.close();
    }

    public static int checkArmstrong(int number){

        int originalNumber = number;
        int lengthOfNumber = String.valueOf(Math.abs(number)).length();
        int sum = 0;

        while(number > 0){
            int modulusValue = number % 10;
            double modulusValueAfterPower = Math.pow(modulusValue, lengthOfNumber);
            sum = (int) (sum + modulusValueAfterPower);

            number = number / 10;

        }

        if(originalNumber == sum){
            return 1;
        }

        return 0;
    }
}
