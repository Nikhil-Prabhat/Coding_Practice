class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> permutationList = new ArrayList<>();
        createPermutation(s, s.length(), 0, "", permutationList);
        return permutationList;

    }

    public void createPermutation(String acutalString, int lengthOfString, int currentIndex, String intermediateResult, List<String> resultList) {

        if (currentIndex == lengthOfString) {
            resultList.add(intermediateResult);
            return;
        }

        char currentCharacter = acutalString.charAt(currentIndex);

        if (!Character.isDigit(currentCharacter)) {
            if (Character.isUpperCase(currentCharacter))
                createPermutation(acutalString, lengthOfString, currentIndex + 1, intermediateResult + Character.toLowerCase(currentCharacter), resultList);
            else
                createPermutation(acutalString, lengthOfString, currentIndex + 1, intermediateResult + Character.toUpperCase(currentCharacter), resultList);
        }

        createPermutation(acutalString, lengthOfString, currentIndex + 1, intermediateResult + currentCharacter, resultList);
    }
}