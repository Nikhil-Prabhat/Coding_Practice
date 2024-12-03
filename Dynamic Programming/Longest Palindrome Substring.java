class Solution {
      public String longestPalindrome(String s) {
        String currentPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String currentStr = "";

            for (int j = i; j < s.length(); j++) {
                currentStr += s.charAt(j);
                if (isPalindrome(currentStr) && currentStr.length() > currentPalindrome.length()) {
                    currentPalindrome = currentStr;
                }
            }
        }

        return currentPalindrome;
    }

    private boolean isPalindrome(String s) {
        int lengthOfStr = s.length();
        for (int i = 0; i < lengthOfStr / 2; i++) {
            if (s.charAt(i) != s.charAt(lengthOfStr - i - 1))
                return false;
        }

        return true;
    }
}

// Accepted Solution
class Solution {
    public String longestPalindrome(String s) {
        int startPalindromeIndex = 0;
        int endPalindromeIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLengthPalindrome = checkPalindrome(i, i, s);
            int evenLengthPalindrome = checkPalindrome(i, i + 1, s);

            int actualLengthOfPalindrome = Math.max(oddLengthPalindrome, evenLengthPalindrome);
            if (actualLengthOfPalindrome > endPalindromeIndex - startPalindromeIndex) {
                startPalindromeIndex = i - (actualLengthOfPalindrome - 1) / 2;
                endPalindromeIndex = i + (actualLengthOfPalindrome) / 2;
            }
        }

        return s.substring(startPalindromeIndex, ++endPalindromeIndex);

    }

    public int checkPalindrome(int left, int right, String str) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
