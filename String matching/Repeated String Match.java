class Solution {

    int PRIME = 101;
    int COUNTER = 5;

    public int repeatedStringMatch(String a, String b) {
        String strToAdd = a;
        int repeatCounter = 1;
        while (COUNTER-- > 0) {
            boolean isPatternFound = ifPatternFoundInString.test(b, a);
            if (isPatternFound) {
                return repeatCounter;
            }

            a = a + strToAdd;
            repeatCounter++;
        }

        return -1;
    }

    private boolean checkIfPatternFound(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHash = calculateHash(pattern, patternLength);
        int textHash = calculateHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash) {
                int j;
                for (j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if (j == patternLength) {
                    return true;
                }
            }

            if (i < textLength - patternLength) {
                textHash = reCalculateHash(text, i, i + patternLength, textHash, patternLength);
            }
        }

        return false;
    }

    private int calculateHash(String text, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash += text.charAt(i) * Math.pow(PRIME, i);
        }

        return hash;
    }

    private int reCalculateHash(String text, int oldIndex, int newIndex, int oldHash, int patternLength) {
        int newHash = oldHash - text.charAt(oldIndex);
        newHash /= PRIME;
        newHash += (text.charAt(newIndex) * Math.pow(PRIME, patternLength - 1));
        return newHash;
    }

    private BiPredicate<String, String> ifPatternFoundInString = (pattern, text) -> pattern.length() <= text.length() && checkIfPatternFound(pattern, text);
}
// Accepted Solution
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (b.equals("")) return 0;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            ++count;
        }
        if (sb.toString().contains(b)) return count;
        sb.append(a);
        return sb.toString().contains(b) ? ++count : -1;
    }
}
