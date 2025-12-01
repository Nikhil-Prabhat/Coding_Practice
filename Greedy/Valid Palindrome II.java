class Solution {
    public boolean palindromeHelper(int i,int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i<j){
            char left = s.charAt(i);
            char right = s.charAt(j);

            if(left != right){
                return palindromeHelper(i+1,j,s) || palindromeHelper(i,j-1,s);
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}

// Tried Solution

class Solution {
    private long countOddCharacters(String s) {
        Map<Character, Long> charMap = s.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));

        return charMap.values()
                .stream()
                .filter(count -> count % 2 != 0)
                .count();
    }

    public boolean validPalindrome(String s) {
        long oddCharCount = countOddCharacters(s);
        return oddCharCount == 2 ? checkPalindromeValidityWhenOddCharCountIs2(s) : (oddCharCount <= 1 ? true : false);
    }

    private boolean checkPalindromeValidityWhenOddCharCountIs2(String s) {
        char[] sCharArray = s.toCharArray();
        int charArrayLen = sCharArray.length;

        for (int i = 0; i < charArrayLen; i++) {
            var currentIndex = i;
            var lastIndex = charArrayLen - i - 1;
            if (currentIndex <= lastIndex && sCharArray[currentIndex] != sCharArray[lastIndex]) {
                if (lastIndex - currentIndex != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
