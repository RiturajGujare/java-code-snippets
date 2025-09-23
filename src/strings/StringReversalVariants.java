package strings;

import java.util.Arrays;
import java.util.Scanner;

/*
    * This program demonstrates different methods to reverse a string or sentence in Java.
    * It includes reversing a single word, reversing an entire sentence, and reversing the order of words in a sentence while keeping the words intact.
    * The program uses the StringBuilder class for efficient string manipulation.
 */
public class StringReversalVariants {
    
    public static void main(String[] args) {
        
        // Taking input from the user for the word and sentence to reverse
        Scanner sc = new Scanner(System.in);

        // Reversing a single word using StringBuilder
        System.out.println("Enter the word you want to reverse: ");
        String wordToReverse = sc.nextLine();

        // Using StringBuilder to reverse the word
        String reversedWord = new StringBuilder(wordToReverse).reverse().toString();

        // Displaying the reversed word
        System.out.println("Word reversed using String Builder method: " + reversedWord);


        // Reversing an entire sentence and reversing the order of words in a sentence
        System.out.println("Enter the sentence you want to reverse:");
        String sentenceToReverse = sc.nextLine();

        // Reversing the entire sentence using StringBuilder
        String reversedSentence = new StringBuilder(sentenceToReverse).reverse().toString();
        System.out.println("Sentence reversed using string builder: " + reversedSentence);


        // Reversing the order of words in a sentence while keeping the words intact
        String[] words = sentenceToReverse.split("\\s");   // splitting the sentence into words based on whitespace 
        System.out.println("words in the sentences" + Arrays.toString(words));  // displaying the words in the sentence

        // Using StringBuilder to reverse the order of words
        StringBuilder reversedWords = new StringBuilder();

        // Appending words in reverse order
        for(int i = words.length - 1; i >= 0; i--){   // iterating from the last word to the first word
            reversedWords.append(words[i]);    // appending the current word to the StringBuilder
            if(i != 0){  // adding a space after each word except the last one
                reversedWords.append(" ");
            }
        }

        // Displaying the sentence with words in reverse order
        System.out.println("Sentence reversed using StringBuilder and keeping the words intact: " + reversedWords);

        sc.close(); // Closing the scanner object to prevent resource leaks
    }
}
