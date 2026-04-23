class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> letterCombinationList = new ArrayList<>();
        Map<Integer, String> lettersMap = initLettersMap();
        generateCombinations(letterCombinationList, lettersMap, digits, 0, new StringBuilder());
        return letterCombinationList;
    }

    private Map<Integer, String> initLettersMap() {
        Map<Integer, String> lettersMap = new HashMap<>();
        lettersMap.put(2, "abc");
        lettersMap.put(3, "def");
        lettersMap.put(4, "ghi");
        lettersMap.put(5, "jkl");
        lettersMap.put(6, "mno");
        lettersMap.put(7, "pqrs");
        lettersMap.put(8, "tuv");
        lettersMap.put(9, "wxyz");

        return lettersMap;
    }

    private void generateCombinations(List<String> letterCombinationList, Map<Integer, String> lettersMap,
            String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            letterCombinationList.add(stringBuilder.toString());
            return;
        }

        String mappedLettersStr = lettersMap.get(digits.charAt(index) - '0');
        IntStream.range(0, mappedLettersStr.length())
                .forEach(idx -> {
                    stringBuilder.append(mappedLettersStr.charAt(idx));
                    generateCombinations(letterCombinationList, lettersMap, digits, index + 1, stringBuilder);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                });

    }
}
