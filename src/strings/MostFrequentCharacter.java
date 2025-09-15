package strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/*

 * Program to find the frequency of each character in a string
 * and identify the most frequently occurring character.

 */

 public class MostFrequentCharacter {
    
   public static void main(String[] args) {

     String word = "My name is Rituraj Gujare";

     // Step 1: Build frequency map (ignoring spaces and case)
     Map<Character, Long> frequencyMap = word.toLowerCase()
                                        .chars()
                                        .mapToObj(ch -> (char) ch)
                                        .filter(ch -> ch !=' ')
                                        .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                        ));

    System.out.println("Frequency Map of character: " + frequencyMap);

    // Step 2: Find the most frequent character
    Character mostFrequentCharacter = frequencyMap.entrySet()
                                        .stream()  // - Convert the frequencyMap into a stream of entries (Map.Entry<Character, Long>)
                                        .max(Map.Entry.comparingByValue())  // - Use max() with comparingByValue() to find the entry with the highest frequency
                                        .map(Map.Entry::getKey)   // - Extract the character (key) from that entry
                                        .orElse(null);   // - If the string is empty, return null (orElse handles empty case)
                                        
    System.out.println("Most frequently occured character is: " + mostFrequentCharacter);

   }
    
}
