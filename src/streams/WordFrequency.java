package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency {
    
    public static void main(String[] args) {
        
        String sentence = "My name is Gujare Rituraj Gujare Son of Rajendra Gujare";

        List<String> words = Arrays.asList(sentence.toLowerCase().split("\\s+"));

        Map<String, Long> frequencyMap = words.stream()
                                        .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                        ));

        System.out.println("Frequency of each word: " + frequencyMap);

        String mostOccuredWord = frequencyMap.entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElseThrow();

        System.out.println("Most occured word in the sentence is: " + mostOccuredWord);
    }
}
