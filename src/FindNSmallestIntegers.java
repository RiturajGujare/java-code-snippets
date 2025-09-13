import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindNSmallestIntegers {
    
    public static void main(String[] args) {
        
        //Given is the Integer list
        List<Integer> listOfIntegers = Arrays.asList(12, 23, 33, 45, 54, 12, 90, 34, 9, 25);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find smallest integers: ");
        int n = sc.nextInt();

        List<Integer> nthList = listOfIntegers.stream()
                                .sorted(Comparator.reverseOrder())
                                .distinct()
                                .limit(n)
                                .collect(Collectors.toList());

        System.out.println("List of " + n + " smallest integers: " + nthList);

        sc.close();
    }
}
