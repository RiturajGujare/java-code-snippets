package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumbers {
    
    public static void main(String[] args) {
        
        //Given the list of integers
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(23);
        listOfIntegers.add(12);
        listOfIntegers.add(37);
        listOfIntegers.add(48);
        listOfIntegers.add(4);

        System.out.println("Original list:" + listOfIntegers);  //print the original list

        List<Integer> evenIntegerList = listOfIntegers.stream()  //stream the original list
                                        .filter(n -> n%2 == 0)   //filter even integers
                                        .collect(Collectors.toList());   //collect the list
        
        System.out.println("Even integer list: " + evenIntegerList);   // even integer list
    }
}
