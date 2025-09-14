package strings;

public class PalindromeChecker {

    // Define messages for palindrome check results
        private static final String IS_PALINDROME = "String is Palindrome";
        private static final String NOT_A_PALINDROME = "String is not Palindrome";
    
    public static void main(String[] args) {

        // String to check for palindrome property
        String stringToCheck = "Madam";
        stringToCheck = stringToCheck.toLowerCase();  // Convert to lowercase for case-insensitive comparison

        //Method 1: Using StringBuilder to reverse the string
        String palindromeCheck = new StringBuilder(stringToCheck).reverse().toString();

        if(palindromeCheck.equals(stringToCheck)){
            System.out.println(IS_PALINDROME);
        }

        else{
            System.out.println(NOT_A_PALINDROME);
        }


        //Method 2: using two-pointer technique

        int returnValue = checkPalindrome(stringToCheck);
        System.out.println(returnValue == 1 ? IS_PALINDROME : NOT_A_PALINDROME);
        
    }

    // Function to check if a string is a palindrome using two-pointer technique
    public static int checkPalindrome(String wordToCheck){

        String wordString = wordToCheck;
        int left = 0;
        int right = wordString.length() - 1;

        //compare characters from both ends of the string
        while(left < right){
            if(wordString.charAt(left) != wordString.charAt(right)){
                return 0;
            }
            left++;
            right--;
        }

        return 1;
    }
}
