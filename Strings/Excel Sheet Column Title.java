class Solution {
    public String convertToTitle(int columnNumber) {
        Map<Integer, Character> characterMap = new HashMap<>();
        String title = "";

        // Character Map Initialisation
        IntStream.range(0, 25).forEach(
                index -> characterMap.put(index + 1, (char) (65 + index))
        );
        characterMap.put(0, 'Z');

        while(columnNumber != 0) {
            var columnQuotient = columnNumber / 26;
            var columnRemainder = columnNumber % 26;
            columnQuotient = columnRemainder == 0 ? columnQuotient -1: columnQuotient;
            title = characterMap.get(columnRemainder) + title;
            columnNumber = columnQuotient;
        }
        
        return title;
    }
}
