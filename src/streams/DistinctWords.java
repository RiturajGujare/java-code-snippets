package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/*
 * This program demonstrates how to find distinct and unique words from a given sentence using Java Streams.
 * Distinct words are those that appear at least once, while unique words are those that appear exactly once.
 * The program uses two methods to find distinct words: one using Map operations and another using the distinct() method.
 * It also finds unique words using Map filtering.
 */

 
public class DistinctWords {
    
    public static void main(String[] args) {
        
        String sentence = "I love Java and I love coding in Java"; // Given sentence to find distinct and unique words

        // Split the sentence into words and convert to lowercase for uniformity
        List<String> words = Arrays.asList(sentence.toLowerCase().split("\\s+")); 

        //Method 1 to get distinct words
        Map<String, Long> frequencyMap1 = words.stream()
                                        .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                        )); // LinkedHashMap to maintain insertion order

        
        List<String> distinctWordsList = frequencyMap1.entrySet()
                                        .stream()  //stream of map entries
                                        .map(Map.Entry::getKey)   //get the keys (distinct words)
                                        .collect(Collectors.toList()); //collecting keys into a list

        //printing the results to find distinct words
        System.out.println("Total Distinct words present in the sentence using Map operations are: " + distinctWordsList.size());
        System.out.println("Distinct words using Map Operations are :" + distinctWordsList);
        System.out.println("-------");

        //Method 2 to get distinct words
        List<String> distinctWordsList2 = words.stream()
                                            .distinct()   //intermediate operation to filter distinct words
                                            .sorted()     //sorting the distinct words
                                            .collect(Collectors.toList());     //collecting distinct words into a list     
        
        //printing the results to find distinct words
        System.out.println("Total distinct words using distinct method are: " + distinctWordsList2.size());
        System.out.println("List of distinct words using distinct method: " + distinctWordsList2);
        System.out.println("-------");


        //Finding Unique words (words that appear exactly once)
        List<String> UniqueWords = frequencyMap1.entrySet()
                                    .stream()    //stream of map entries
                                    .filter(entry -> entry.getValue() == 1)    //filtering entries with value 1 (unique words)
                                    .map(Map.Entry::getKey)    //getting the keys (unique words)
                                    .collect(Collectors.toList());  //collecting unique words into a list
        
        //printing the results to find unique words
        System.out.println("Total Unique words are: " + UniqueWords.size());
        System.out.println("List of Unique words: " + UniqueWords);

    }
}
