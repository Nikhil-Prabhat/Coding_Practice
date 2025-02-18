class Solution {
    public int minimumMoves(String s) {
        int count = 0;
        int strLen = s.length();

        if (strLen < 4) {
            return isCharFound(s) ? 1 : 0;
        }

        for (int i = 0; i < strLen;) {
            if (s.charAt(i) == 'O') {
                i += 1;
                continue;
            }

            int endIndex = i + 3 < strLen ? i + 3 : strLen;
            if (isCharFound(s.substring(i, endIndex)))
                count++;

            i += 3;
        }

        return count;
    }

    private boolean isCharFound(String str) {
        return IntStream.range(0, str.length())
                .anyMatch(index -> str.charAt(index) == 'X');
    }
}
