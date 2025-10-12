package arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    
    public static void main(String[] args) {
        
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};

        int length1 = arr1.length;
        int length2 = arr2.length;

        for(int i = 0; i< length1; i++){
            if(arr1[i] > arr2[0]){
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                int first = arr2[0];

                int j;
                for( j = 1; j < length2 && arr2[j] < first; j++){
                    arr2[j-1] = arr2[j];
                }
                arr2[j-1] = first;
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
