class Solution {
    public int minSwaps(String s) {
        Stack<Character> characterStack = new Stack<>();
        int mismatchCharacter = 0;

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);

            if (currentChar == '[') {
                characterStack.push(currentChar);
            } else {

                // Remove balanced character
                if (!characterStack.isEmpty()) {
                    characterStack.pop();
                    continue;
                }

                mismatchCharacter++;
            }
        }

        return (mismatchCharacter + 1) / 2;
    }
}