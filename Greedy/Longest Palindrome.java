class Solution {

    int lengthOfLargestPalindrome = 0;
    Boolean isOdd = false;
    
     public int longestPalindrome(String s) {
        Map<Character, Integer> characterMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            characterMap.put(s.charAt(i), characterMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        characterMap.entrySet().forEach(
                map -> {
                    if (map.getValue() % 2 == 0)
                        lengthOfLargestPalindrome += map.getValue();
                    else {
                        lengthOfLargestPalindrome += (map.getValue() - 1);
                        isOdd = true;
                    }
                }
        );
        
        return isOdd ? lengthOfLargestPalindrome+1 : lengthOfLargestPalindrome;
    }
}