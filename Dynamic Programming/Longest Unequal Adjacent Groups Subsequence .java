class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> resultList = new ArrayList<>();

        // Case 1 : When the size is 1
        if (groups.length == 1) {
            resultList.add(words[0]);
            return resultList;
        }

        // Case 2 : When the size is 2
        if (groups.length == 2) {
            if (groups[0] != groups[1]) {
                resultList.add(words[0]);
                resultList.add(words[1]);
                return resultList;
            } else {
                resultList.add(words[0]);
                return resultList;
            }
        }

        // Case 3 : Rest cases
        for (int i = 0; i < words.length - 1 && words.length >= 3; i++) {
            if (resultList.isEmpty()) {
                resultList.add(words[i]);
            }

            if (groups[i] != groups[i + 1]) {
                resultList.add(words[i + 1]);
            }
        }
        return resultList;
    }
}