class Solution {
    public int countGoodSubstrings(String s) {

        int count = 0;
        Set<Character> setOfCharacters = new HashSet<>();

        for (int i = 0; i < s.length() - 2 && s.length() >= 3; i++) {
            for (int j = i; j < i + 3; j++) {
                if (!setOfCharacters.contains(s.charAt(j)))
                    setOfCharacters.add(s.charAt(j));
            }
            if (setOfCharacters.size() == 3)
                count++;
            setOfCharacters.clear();
        }
        return count;
    }
}