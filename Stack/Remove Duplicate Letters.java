class Solution {
    PriorityQueue<String> priorityQueue = new PriorityQueue<>();

    public String removeDuplicateLetters(String s) {
        int targetMask = 0;

        for (char character : s.toCharArray()) {
            targetMask |= 1 << (character - 'a');
        }

        generateUniqueStrings(s, 0, "", 0, targetMask);
        return priorityQueue.peek();
    }

    private void generateUniqueStrings(String originalStr, int currentIndex, String currentStr, int currentMask,
            int targetMask) {
        if (currentIndex == originalStr.length()) {
            if (currentMask == targetMask) {
                priorityQueue.add(currentStr);
            }

            return;
        }

        char currentChar = originalStr.charAt(currentIndex);
        int currentBit = 1 << (currentChar - 'a');

        if ((currentBit & currentMask) == 0)
            generateUniqueStrings(originalStr, currentIndex + 1, currentStr + currentChar, currentMask | currentBit,
                    targetMask);
        generateUniqueStrings(originalStr, currentIndex + 1, currentStr, currentMask, targetMask);
    }
}

// Accepted Answer
class Solution {

    public String removeDuplicateLetters(String s) {

        // Stores the number of remaining occurrences
        // of every lowercase English letter.
        int[] frequency = new int[26];

        // Tracks whether a character is already
        // present in the result.
        boolean[] included = new boolean[26];

        // Count the frequency of every character.
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        // Used as a monotonic stack.
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {

            // The current occurrence is now being processed.
            frequency[ch - 'a']--;

            // Avoid adding duplicate characters.
            if (included[ch - 'a']) {
                continue;
            }

            // Remove larger characters when they appear
            // again later in the string.
            while (
                result.length() > 0
                && result.charAt(result.length() - 1) > ch
                && frequency[
                    result.charAt(result.length() - 1) - 'a'
                ] > 0
            ) {
                char removed =
                    result.charAt(result.length() - 1);

                result.deleteCharAt(result.length() - 1);

                included[removed - 'a'] = false;
            }

            // Add the current character.
            result.append(ch);
            included[ch - 'a'] = true;
        }

        return result.toString();
    }
}
