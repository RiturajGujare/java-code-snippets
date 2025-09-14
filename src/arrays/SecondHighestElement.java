package arrays;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestElement {
    
    public static void main(String[] args) {
        
        //Given is the list of Integer
        List<Integer> listOfInteger = Arrays.asList(23, 21, 45, 12, 89, 76, 10);
        
        Integer secondHighestInteger = listOfInteger.stream()    //convert the list to stream
                                        .sorted(Comparator.reverseOrder()) //sort using the reverse order
                                        .distinct()   //take on the unique intergers
                                        .skip(1)    //skip the 1st integer
                                        .findFirst()  //take the 1st integer after above operations
                                        .orElse(null);  //if no element is found then return null

        System.out.println("Second Highest Integer is: " + secondHighestInteger);
    }
}
