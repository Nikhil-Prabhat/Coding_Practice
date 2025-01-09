class Solution {
    public boolean equationsPossible(String[] equations) {

        Character[] parentArray = new Character[26];
        IntStream.range(0, 26)
                .forEach(index -> parentArray[index] = (char) ((int) 'a' + index));

        Arrays.stream(equations)
                .filter(equation -> equation.charAt(1) != '!')
                .forEach(equation -> {
                    var firstChar = equation.charAt(0);
                    var secondChar = equation.charAt(3);
                    union(firstChar, secondChar, parentArray);
                });

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                var parentFirstChar = findParent(parentArray, equation.charAt(0));
                var parentSecondChar = findParent(parentArray, equation.charAt(3));

                if (Character.compare(parentFirstChar, parentSecondChar) == 0)
                    return false;
            }
        }

        return true;
    }

    private void union(Character firstChar, Character secondChar, Character[] parentArray) {
        var parentOfFirstChar = findParent(parentArray, firstChar);
        var parentOfSecondChar = findParent(parentArray, secondChar);

        IntStream.range(0, 26)
                .forEach(index -> {
                    if (Character.compare(parentArray[index], parentOfFirstChar) == 0) {
                        parentArray[index] = parentOfSecondChar;
                    }
                });
    }

    private Character findParent(Character[] parentArray, Character currentChar) {
        return parentArray[currentChar - 'a'];
    }
}
