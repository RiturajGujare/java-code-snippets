package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        List<Integer> distinctList1 = Arrays.stream(nums1)
                                        .boxed()
                                        .distinct()
                                        .collect(Collectors.toList());

        List<Integer> distictList2 = Arrays.stream(nums2)
                                        .boxed()
                                        .distinct()
                                        .collect(Collectors.toList());

        List<Integer> intersectionList = new ArrayList<>();

        for(int number: distinctList1){
            if(distictList2.contains(number)){
                intersectionList.add(number);
            }
        }

        int[] intersectingArray = intersectionList.stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();
        for(int num: intersectingArray){
            System.out.print(num);
        }  
        
    }
}
