package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciTillLimit {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number till which fibonaaci series you need to find: ");
        int number = sc.nextInt();

        List<Integer> listOfFibonaaciNumbers = new ArrayList<>();
        int first = 0, second = 1;
        int result = first + second;

        listOfFibonaaciNumbers.add(first);
        listOfFibonaaciNumbers.add(second);

        while(result <= number) {
            listOfFibonaaciNumbers.add(result);
            first = second;
            second = result;
            result = first + second;
        }
        
        System.out.println("Fibonacci series till " + number + " is: " + listOfFibonaaciNumbers);
        sc.close();
    }
}
