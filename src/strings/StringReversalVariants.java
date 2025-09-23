package strings;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 */
public class StringReversalVariants {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word you want to reverse: ");
        String wordToReverse = sc.nextLine();

        String reversedWord = new StringBuilder(wordToReverse).reverse().toString();

        System.out.println("Word reversed using String Builder method: " + reversedWord);

        System.out.println("Enter the sentence you want to reverse:");
        String sentenceToReverse = sc.nextLine();

        String reversedSentence = new StringBuilder(sentenceToReverse).reverse().toString();
        System.out.println("Sentence reversed using string builder: " + reversedSentence);

        String[] words = sentenceToReverse.split("\\s");
        System.out.println("words in the sentences" + Arrays.toString(words));

        StringBuilder reversedWords = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--){
            reversedWords.append(words[i]);
            if(i != 0){
                reversedWords.append(" ");
            }
        }

        System.out.println("Sentence reversed using StringBuilder and keeping the words intact: " + reversedWords);

        sc.close();
    }
}
