package strings;

// This program finds the longest common substring between two input strings using dynamic programming.
public class LongestCommonSubstring {
    
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "zcdemf";

        String result = longestCommonSubstring(str1, str2);
        System.out.println("Longest Common Substring: " + result);
    }

    public static String longestCommonSubstring(String str1, String str2){

        int length1 = str1.length();
        int length2 = str2.length();

        int[][] dp = new int[length1+1][length2+1];
        int maxLength = 0;
        int endIndex = 0;

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(str1.charAt(i-1) ==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;

                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(endIndex - maxLength, endIndex);
    }
}
