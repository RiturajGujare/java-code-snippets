package collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveNullValuesFromList {
    
    public static void main(String[] args) {
        
        // Initializing a list with some null values
        List<Integer> listOfIntegers = Arrays.asList(23, 34, null, 45, 90, 7, null, 65);

        // Removing null values using Java Streams
        List<Integer> listWithoutNull = listOfIntegers.stream()
                                        .filter(entry -> entry != null)  // Filtering out null values
                                        .collect(Collectors.toList());
        
        // Printing the list after removing null values
        System.out.println("List after removing null values: " + listWithoutNull);
    }
}
