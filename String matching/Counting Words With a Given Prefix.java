class Solution {
public int prefixCount(String[] words, String pref) {
        long count = Arrays.stream(words)
                .filter(word -> word.startsWith(pref))
                .count();
        return (int) count;
    }
}