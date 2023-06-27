class Solution {
    public String makeSmallestPalindrome(String s) {
       Character[] palindromeCharacterArray = new Character[s.length()];
        int lengthOfString = s.length();

        // First update the character array with the original string
        for (int i = 0; i < lengthOfString; i++)
            palindromeCharacterArray[i] = s.charAt(i);

        // Make the lexicographically smallest palindrome
        for (int i = 0; i < lengthOfString / 2; i++) {
            if (palindromeCharacterArray[i] - 'a' < palindromeCharacterArray[lengthOfString - i - 1] - 'a')
                palindromeCharacterArray[lengthOfString - i - 1] = palindromeCharacterArray[i];
            else
                palindromeCharacterArray[i] = palindromeCharacterArray[lengthOfString - i - 1];
        }

        String palindromeString = "";
        for (int i = 0; i < lengthOfString; i++)
            palindromeString += palindromeCharacterArray[i];

        return palindromeString; 
    }
}