package numbers;

import java.util.Scanner;

public class PowerOfN {

    public static boolean checkNumberisPower(int number, int baseNumber){

        if(number < 1 || baseNumber < 2){
            return false;
        }
        while (number%baseNumber == 0) {
            number= number/baseNumber;
        }
        if(number == 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int number = sc.nextInt();
        System.out.println("Enter the base number: ");
        int baseNumber = sc.nextInt();

        boolean returnValue = checkNumberisPower(number, baseNumber);
        if(returnValue){
            System.out.println("Number " + number + " is power number of base number " + baseNumber);
        }
        else{
            System.out.println("Number " + number + " is not power number of base number " + baseNumber);
        }

        sc.close();
    }
}
