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
