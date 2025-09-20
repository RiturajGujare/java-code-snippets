package collections;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValues {
    
    public static void main(String[] args) {
        
        // Initializing a map with some fruit and their quantities
        Map<String, Integer> mapOfFruit = Map.of(
            "Apple", 3,
            "Orange", 5,
            "Pineapple", 9,
            "Kiwi", 2,
            "Coconut", 8       
        );

        // Sorting the map by values using Java Streams
        Map<String, Integer> sortedFruitMapInAscendingOrder = mapOfFruit.entrySet()
                                                                .stream()    // Converting map to stream
                                                                .sorted(Map.Entry.comparingByValue())  // Sorting by value
                                                                .collect(Collectors.toMap(
                                                                    Map.Entry::getKey,   // Getting key
                                                                    Map.Entry::getValue,  // Getting value
                                                                    (e1, e2) -> e1,   // If there are duplicate keys, keep the existing one
                                                                    LinkedHashMap::new)); // Collecting to a LinkedHashMap to maintain order

        // Printing the sorted map in ascending order
        System.out.println("Sorted fruit map based on value in ascending order");
        System.out.println(sortedFruitMapInAscendingOrder);

        // Sorting the map by values in descending order
        Map<String, Integer> sortedFruitMapInDescendingOrder = mapOfFruit.entrySet()
                                                                .stream()  // Converting map to stream
                                                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Sorting by value in descending order
                                                                .collect(Collectors.toMap(
                                                                    Map.Entry::getKey, 
                                                                    Map.Entry::getValue,
                                                                    (e1, e2) -> e1,
                                                                    LinkedHashMap::new));
        
        //printing the sorted map in descending order
        System.out.println("Sorted fruit map based on value in descending order");
        System.out.println(sortedFruitMapInDescendingOrder);


    }
}
