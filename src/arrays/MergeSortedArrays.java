package arrays;

import java.util.Arrays;

/*
 * This program merges two sorted arrays without using extra space.
 * The first array is modified to contain the smallest elements and the second array contains the remaining elements
 */
public class MergeSortedArrays {
    
    public static void main(String[] args) {
        
        // Example usage
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};

        int length1 = arr1.length;  // Length of first array
        int length2 = arr2.length;  // Length of second array

        // Merging the two sorted arrays
        // for each element in arr1, if it is greater than the first element of arr2, swap them and then sort arr2
        for(int i = 0; i< length1; i++){

            // If current element of arr1 is greater than the first element of arr2
            if(arr1[i] > arr2[0]){

                // Swap arr1[i] and arr2[0]
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                // Move the first element of arr2 to its correct position to maintain sorted order
                int first = arr2[0];

                int j;
                // Shift elements of arr2 to the left until the correct position for 'first' is found
                for( j = 1; j < length2 && arr2[j] < first; j++){

                    // Shift element to the left
                    arr2[j-1] = arr2[j];
                }
                // Place 'first' at its correct position
                arr2[j-1] = first;
            }
        }

        // Printing the merged arrays
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
