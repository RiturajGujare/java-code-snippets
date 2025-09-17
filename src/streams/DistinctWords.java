package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/*
 * program to find distinct and unique words in the sentence
 * Distinct words are the words which appear atleast once, we have implemented two methods to find distinct words
 * Unique words are the words which appear exactly once
 */
public class DistinctWords {
    
    public static void main(String[] args) {
        
        String sentence = "I love Java and I love coding in Java";

        List<String> words = Arrays.asList(sentence.toLowerCase().split("\\s+")); 

        //Method 1 to get distinct words
        Map<String, Long> frequencyMap1 = words.stream()
                                        .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                        ));

        List<String> distinctWordsList = frequencyMap1.entrySet()
                                        .stream()
                                        .map(Map.Entry::getKey)
                                        .collect(Collectors.toList());

        System.out.println("Total Distinct words present in the sentence using Map operations are: " + distinctWordsList.size());
        System.out.println("Distinct words using Map Operations are :" + distinctWordsList);
        System.out.println("-------");

        //Method 2 to get distinct words
        List<String> distinctWordsList2 = words.stream()
                                                    .distinct()
                                                    .sorted()
                                                    .collect(Collectors.toList());
        
        System.out.println("Total distinct words using distinct method are: " + distinctWordsList2.size());
        System.out.println("List of distinct words using distinct method: " + distinctWordsList2);
        System.out.println("-------");

        List<String> UniqueWords = frequencyMap1.entrySet()
                                    .stream()
                                    .filter(entry -> entry.getValue() == 1)
                                    .map(Map.Entry::getKey)
                                    .collect(Collectors.toList());
        
        System.out.println("Total Unique words are: " + UniqueWords.size());
        System.out.println("List of Unique words: " + UniqueWords);
                                

        


    }
}
