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
        
        List<Integer> listOfIntegers = Arrays.asList(23, 13, 44, 23, 10, 56, 78, 90, 10);

        Set<Integer> setOfUniqueValues = new HashSet<>();
        for(int number: listOfIntegers){
            setOfUniqueValues.add(number);
        }
                    
        System.out.println("List of unique integers using Set: " + setOfUniqueValues);
        System.out.println("------");

        Map<Integer, Long> frequencyMap = listOfIntegers.stream()
                                            .collect(Collectors.groupingBy(
                                                Function.identity(),
                                                LinkedHashMap::new,
                                                Collectors.counting()
                                            ));

        List<Integer> listOfDuplicateIntegers = frequencyMap.entrySet()
                                                .stream()
                                                .filter(entry -> entry.getValue() > 1)
                                                .map(Map.Entry::getKey)
                                                .collect(Collectors.toList());

                                        
        System.out.println("List of duplicate integers: " + listOfDuplicateIntegers);


        Set<Integer> setOfUniqueValues2 = frequencyMap.entrySet()
                                            .stream()
                                            .map(Map.Entry::getKey)
                                            .collect(Collectors.toSet());

        System.out.println("List of Unique integers using Map and Stream: " + setOfUniqueValues2);
    }
}
