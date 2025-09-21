package strings;

import java.util.Arrays;
import java.util.Scanner;


/*
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * For example, the word "listen" is an anagram of "silent".
 * This program checks if two input strings are anagrams of each other.
 */
public class AnagramCheck {
    
    public static void main(String[] args) {
        
        // Taking input from the user
        Scanner sc = new Scanner(System.in);

        // Preprocessing the input strings: converting to lowercase and removing spaces
        System.out.println("Enter first word: ");
        String firstWord = sc.nextLine();
        firstWord = firstWord.toLowerCase().replaceAll("\\s", "");
        // "\\s" is a regex pattern that matches any whitespace character (spaces, tabs, newlines, etc.)
        System.out.println("Enter second word: ");
        String secondWord = sc.nextLine();
        secondWord = secondWord.toLowerCase().replaceAll("\\s", "");

        // Converting strings to character arrays and sorting them
        char[] array1 = firstWord.toCharArray();
        char[] array2 = secondWord.toCharArray();

        // Sorting the character arrays
        Arrays.sort(array1);
        Arrays.sort(array2);

        // If lengths are not equal, they cannot be anagrams
        if(firstWord.length() != secondWord.length()){
            System.out.println("Not Anagram");
            sc.close(); // Closing the scanner to prevent resource leaks
            return;  // Exiting the program
        }
        
        // Comparing the sorted character arrays
        System.out.println(Arrays.equals(array1, array2) ? "Anagram ": " Not Anagram" );

        sc.close(); // Closing the scanner to prevent resource leaks
    }
}
