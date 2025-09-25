class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> wordPatternMap = new HashMap<>();
        String[] wordsInStr = s.split(" ");

        if (pattern.length() != wordsInStr.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentString = wordPatternMap.getOrDefault(currentChar, "");

            if (!currentString.isEmpty() && !currentString.equals(wordsInStr[i])) {
                return false;
            }

            if (currentString.isEmpty()) {
                wordPatternMap.put(currentChar, wordsInStr[i]);
            }
        }

        long countOfUniqueElements = wordPatternMap.values()
                .stream()
                .distinct()
                .count();

        if (countOfUniqueElements != wordPatternMap.size()) {
            return false;
        }

        return true;
    }
}
