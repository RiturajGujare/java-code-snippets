package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the prime you need to check: ");
        int number = sc.nextInt();

        boolean returnValue = isPrime(number);

        System.out.println((returnValue) ? number + " is prime number" : number + " is not a prime number");

        System.out.println("Enter the range till which you need to find prime numbers: ");
        int range = sc.nextInt();

        List<Integer> listOfprimeNumbers = new ArrayList<>();

        for(int i = 0; i <= range; i++){
            if(isPrime(i)){
                listOfprimeNumbers.add(i);
            }
        }

        System.out.println("List of prime numbers till " + range + " are: " + String.join(", ", listOfprimeNumbers.stream()
                                                                                            .map(String::valueOf)
                                                                                            .toArray(String[]::new)));

        sc.close();
    }

    public static boolean isPrime(int number){

        if(number <= 1) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
