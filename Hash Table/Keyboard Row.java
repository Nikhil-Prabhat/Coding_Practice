// Tried Solution
class Solution {
    String[] keyboardRows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    
    public String[] findWords(String[] words) {
        return Arrays.stream(words)
                .filter(this::ifWordIsFromSameKeyboardRow)
                .toArray(String[]::new);
    }

    private Boolean ifWordIsFromSameKeyboardRow(String word) {
        int firstCharRow = findRowForCharInWord(STR."\{Character.toLowerCase(word.charAt(0))}");
        for (int i = 1; i < word.length(); i++) {
            int currentCharRow = findRowForCharInWord(STR."\{Character.toLowerCase(word.charAt(i))}");
            if (firstCharRow != currentCharRow) {
                return false;
            }
        }

        return true;
    }

    private int findRowForCharInWord(String charStr) {
        return IntStream.range(0, keyboardRows.length)
                .filter(index -> keyboardRows[index].contains(charStr))
                .findFirst()
                .orElse(-1);
    }
}

// Accepted Solution
class Solution {
    String[] keyboardRows = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm" };

    public String[] findWords(String[] words) {
        return Arrays.stream(words)
                .filter(this::ifWordIsFromSameKeyboardRow)
                .toArray(String[]::new);
    }

    private Boolean ifWordIsFromSameKeyboardRow(String word) {
        int firstCharRow = findRowForCharInWord(String.valueOf(Character.toLowerCase(word.charAt(0))));
        for (int i = 1; i < word.length(); i++) {
            int currentCharRow = findRowForCharInWord(String.valueOf(Character.toLowerCase(word.charAt(i))));
            if (firstCharRow != currentCharRow) {
                return false;
            }
        }

        return true;
    }

    private int findRowForCharInWord(String charStr) {
        return IntStream.range(0, keyboardRows.length)
                .filter(index -> keyboardRows[index].contains(charStr))
                .findFirst()
                .orElse(-1);
    }
}
