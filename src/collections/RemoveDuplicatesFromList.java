package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {
    
    public static void main(String[] args) {
        
        //Given list of integers with duplicates
        List<Integer> listOfIntegers = Arrays.asList(23, 13, 44, 23, 10, 56, 78, 90, 10);

        //Using Set to remove duplicates
        Set<Integer> setOfUniqueValues = new HashSet<>();
        for(int number: listOfIntegers){
            setOfUniqueValues.add(number);   //Set automatically handles duplicates
        }
        
        //printing the results to find unique integers using Set approach
        System.out.println("Total unique integers using Set: " + setOfUniqueValues.size());  
        System.out.println("List of unique integers using Set: " + setOfUniqueValues);
        System.out.println("------");

        //Method 2 
        //Using Stream and Map to find duplicates and unique integers
        Map<Integer, Long> frequencyMap = listOfIntegers.stream()
                                            .collect(Collectors.groupingBy(
                                                Function.identity(),
                                                LinkedHashMap::new,
                                                Collectors.counting()
                                            ));

        List<Integer> listOfDuplicateIntegers = frequencyMap.entrySet()
                                                .stream()  //stream of map entries
                                                .filter(entry -> entry.getValue() > 1)  //filtering entries with value greater than 1 (duplicates)
                                                .map(Map.Entry::getKey)  //getting the keys (duplicate integers)
                                                .collect(Collectors.toList());  //collecting duplicate integers into a list

        //printing the results to find duplicate integers using Map and Stream approach
        System.out.println("List of duplicate integers: " + listOfDuplicateIntegers);


        //Finding unique integers using Map and Stream approach
        Set<Integer> setOfUniqueValues2 = frequencyMap.entrySet()
                                            .stream()
                                            .map(Map.Entry::getKey)
                                            .collect(Collectors.toSet());  //collecting keys into a Set to ensure uniqueness

        //printing the results to find unique integers using Map and Stream approach
        System.out.println("List of Unique integers using Map and Stream: " + setOfUniqueValues2);
    }
}
