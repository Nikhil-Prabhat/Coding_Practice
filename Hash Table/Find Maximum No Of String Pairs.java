class Solution {
    public int maximumNumberOfStringPairs(String[] words) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            String reversedString = reverseString(word);
            if (!map.containsKey(reversedString))
                map.put(word, 0);
        }

        // It is because the map will contain only distinct words and the pair making words are not being added to the map
        return words.length - map.size();

    }

    private String reverseString(String word) {
        StringBuffer stringBuffer = new StringBuffer(word);
        int lengthOfWord = stringBuffer.length();

        for (int i = 0; i < lengthOfWord / 2; i++) {
            char temp = stringBuffer.charAt(i);
            stringBuffer.setCharAt(i, stringBuffer.charAt(lengthOfWord - i - 1));
            stringBuffer.setCharAt(lengthOfWord - i - 1, temp);

        }

        return stringBuffer.toString();
    }
}