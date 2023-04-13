class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       int asciiOfTarget = (int) target;
        for (int i = 0; i < letters.length; i++) {
            int asciiOfCurrentLetter = (int) letters[i];
            if (asciiOfTarget < asciiOfCurrentLetter) {
                return letters[i];
            }
        }

        return letters[0]; 
    }
}