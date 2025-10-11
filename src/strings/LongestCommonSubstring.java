package strings;

// This program finds the longest common substring between two input strings using dynamic programming.
public class LongestCommonSubstring {
    
    public static void main(String[] args) {
        // Example usage
        String str1 = "abcdef";
        String str2 = "zcdemf";

        // Finding the longest common substring
        String result = longestCommonSubstring(str1, str2);
        System.out.println("Longest Common Substring: " + result);
    }

    // Function to find the longest common substring
    public static String longestCommonSubstring(String str1, String str2){

        int length1 = str1.length();   // Length of first string
        int length2 = str2.length();   // Length of second string

        int[][] dp = new int[length1+1][length2+1];   // DP table to store lengths of longest common suffixes of substrings
        int maxLength = 0;  // Maximum length of common substring found
        int endIndex = 0;   // Ending index of the longest common substring in str1

        // Filling the DP table
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){

                // If characters match, increment the length of common substring
                if(str1.charAt(i-1) ==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;   // Update the DP table

                    // Update maxLength and endIndex if a longer common substring is found
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }

                // If characters do not match, reset the length to 0
                else{
                    dp[i][j] = 0;
                }
            }
        }

        // Extracting the longest common substring from str1 using endIndex and maxLength
        return str1.substring(endIndex - maxLength, endIndex);
    }
}
