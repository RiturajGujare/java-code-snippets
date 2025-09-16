package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * This program is to get the word frequency count
 * and find the most frquent word
 */


public class WordFrequency {
    
    public static void main(String[] args) {
        
        //Given is the input sentence with words
        String sentence = "My name is Gujare Rituraj Gujare Son of Rajendra Gujare";

        //split the sentence in words using the split and regex then store it in list
        List<String> words = Arrays.asList(sentence.toLowerCase().split("\\s+"));


        //Step 1: calculate the frequency of each word
        Map<String, Long> frequencyMap = words.stream()
                                        .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                        ));

        //print the frequency map containing each word and its frequency
        System.out.println("Frequency of each word: " + frequencyMap);

        //Step 2: Find the most occured word
        String mostOccuredWord = frequencyMap.entrySet()
                                .stream() // Convert the frequencyMap into a stream of entries (Map.Entry<String, Long>)
                                .max(Map.Entry.comparingByValue()) //use max() with comparingByValue() to find the entry with the highest frequency
                                .map(Map.Entry::getKey)  //extract the word (key) from that entry
                                .orElseThrow(); //if the sentence is empty, throw an exception (orElseThrow handles empty case)

        //print the most occured word
        System.out.println("Most occured word in the sentence is: " + mostOccuredWord);
    }
}
