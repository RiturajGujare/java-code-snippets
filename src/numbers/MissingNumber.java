package numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * This program finds the missing number in a list of consecutive integers.
 * It demonstrates two methods: one using the highest number in the list and another using the sum of n natural numbers formula.
 */
public class MissingNumber {
    
    public static void main(String[] args) {
        
        // Sample list of numbers with one missing number
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12);

        // Sorting the list to ensure the numbers are in order
        List<Integer> sortedNumbers = numbers.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        
        //method1: using the highest number in the list
        int highestNumber = sortedNumbers.get(sortedNumbers.size() - 1);  // last element in the sorted list

        // Iterating through the list to find the missing number
        for(int i = 0; i < highestNumber; i++){
            if(sortedNumbers.get(i) != i+1){

                // Displaying the missing number
                System.out.println("Missing number from the list is: " + (i+1));
                break;  // breaking the loop once the missing number is found
            }
        }

        //method2: using the sum of n natural numbers formula
        int n = numbers.size() + 1; // since one number is missing  

        int expectedSum = n * (n + 1) / 2; // sum of first n natural numbers

        int actualSum = sortedNumbers.stream()
                        .mapToInt(Integer::intValue)  // converting Integer to int
                        .sum(); // sum of elements in the list

        // Displaying the missing number
        System.out.println("Missing number from the list is: " + (expectedSum - actualSum));
    }
}
