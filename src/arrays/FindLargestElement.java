package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*

 * Program to find the largest element in a list of integers
 * using three different approaches:
 * 1. Stream API with max()
 * 2. Stream API with sorted() + findFirst()
 * 3. Collections.max()

 */

public class FindLargestElement {
    
    public static void main(String[] args) {
        
        // Sample list of integers
        List<Integer> listOfIntegers  = Arrays.asList(12, -3, 67, 98, 21, 1, 10);

        // Approach 1: Using Stream API with max()
        // Iterates the list once and finds the maximum element in O(n)
        Integer largestInteger= listOfIntegers.stream()
                                .max(Integer::compare)
                                .get();



        // Approach 2: Using Stream API with sorted() in reverse order
        // Sorts the list in descending order and picks the first element
        // Less efficient (O(n log n)) but still valid                    
        Integer largestElement = listOfIntegers.stream()
                                .sorted(Comparator.reverseOrder())
                                .findFirst()
                                .orElse(null);

        
        // Approach 3: Using Collections.max()
        // Direct, simple, and efficient way to find the maximum element in O(n)
        Integer largest = Collections.max(listOfIntegers);


        // Print results of all approaches
        System.out.println("Largest Integer in the list using stream and max is: " + largestInteger);
        System.out.println("Largest Integer in the list using stream and sort is: " + largestElement);
        System.out.println("Largest Integer in the list using Collections and max is: " + largest);
    }
}
