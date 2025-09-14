package strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequencyCounter {
    
    public static void main(String[] args) {
        

        //Given input string
        String name = "Rituraj Gujare";

        //create the frequency map
        Map<Character, Long> frequencyMap = name.toLowerCase()   //convert the string to lower case
                                            .chars()   //convert to IntStream
                                            .mapToObj(ch -> (char) ch)  //map the integer value to character
                                            .filter(ch -> ch!= ' ')   //remove the blank spaces
                                            .collect(Collectors.groupingBy(     //collect using grouping by
                                                Function.identity(),     //identity function
                                                LinkedHashMap::new,     //mention insertion order
                                                Collectors.counting()    //count the occurence of each char
                                            ));

        //print the frequency map
        System.out.println(frequencyMap);
    }
}
