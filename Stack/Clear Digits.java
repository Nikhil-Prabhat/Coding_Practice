class Solution {
    public String clearDigits(String s) {
        Stack<Character> characterStack = new Stack<>();
        String finalString = "";

        for (int i = 0; i < s.length(); i++) {
            var currentLetter = s.charAt(i);

            if (Character.isLetter(currentLetter)) {
                characterStack.push(currentLetter);
                continue;
            }

            if (!characterStack.isEmpty())
                characterStack.pop();
        }

        for (int i = 0; i < characterStack.size(); i++) {
            finalString += characterStack.get(i);
        }

        return finalString;
    }
}
