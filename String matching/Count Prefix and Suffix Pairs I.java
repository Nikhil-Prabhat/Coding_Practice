class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        var count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() <= words[j].length() && comparePrefix(words[i], words[j])
                        && compareSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean comparePrefix(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean compareSuffix(String word1, String word2) {
        var indexToStartInWord2 = word2.length() - word1.length();
        String updatedWord2 = word2.substring(indexToStartInWord2);
        return comparePrefix(word1, updatedWord2);
    }
}
