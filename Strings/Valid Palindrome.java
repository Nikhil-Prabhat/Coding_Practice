class Solution {
       public boolean isPalindrome(String s) {
        String palindromeToCheckStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                palindromeToCheckStr += Character.toLowerCase(s.charAt(i));
            }
        }

        return checkIfStrIsPalindrome(palindromeToCheckStr);
    }

    private boolean checkIfStrIsPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
