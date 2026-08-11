class Solution {
    public boolean detectCapitalUse(String word) {
        var areAllLettersCapital = true;
        var isFirstLetterCapital = true;
        var isFirstLetterSmall = true;
        var areAllLettersSmall = true;

        isFirstLetterCapital = Character.isUpperCase(word.charAt(0));
        isFirstLetterSmall = Character.isLowerCase(word.charAt(0));
        areAllLettersCapital = areAllCharsInAppropriateCase(word, Character::isUpperCase);
        areAllLettersSmall = areAllCharsInAppropriateCase(word, Character::isLowerCase);

        return (isFirstLetterCapital && areAllLettersSmall) || (isFirstLetterCapital && areAllLettersCapital) || (isFirstLetterSmall && areAllLettersSmall);
    }

    private boolean areAllCharsInAppropriateCase(String word, Predicate<Character> matchingPredicate) {
        for (int i = 1; i < word.length(); i++) {
            if (!matchingPredicate.test(word.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
