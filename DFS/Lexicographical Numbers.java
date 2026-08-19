class Solution {
    Set<Integer> lexicalOrderedSet = new LinkedHashSet<>();

    public List<Integer> lexicalOrder(int n) {
        IntStream.rangeClosed(1, 10)
                .forEach(index -> iterateNumbers(new StringBuilder(String.valueOf(index)), n));
        return lexicalOrderedSet.stream()
                .toList();
    }

    private void iterateNumbers(StringBuilder currentNumStrBuilder, int maxNumber) {
        // Bounding Condition
        if (Integer.parseInt(currentNumStrBuilder.toString()) > maxNumber) {
            return;
        }

        addNumberToTheList.accept(currentNumStrBuilder, maxNumber);

        for (int i = 0; !currentNumStrBuilder.isEmpty() && i <= 9; i++) {
            currentNumStrBuilder.append(i);
            iterateNumbers(currentNumStrBuilder, maxNumber);
            currentNumStrBuilder.deleteCharAt(currentNumStrBuilder.length() - 1);
        }
    }

    private BiConsumer<StringBuilder, Integer> addNumberToTheList = (currentNumStrBuilder, numberToCompare) -> {
        var currentNumStr = currentNumStrBuilder.toString();
        if (!currentNumStr.isEmpty() && Integer.parseInt(currentNumStr) <= numberToCompare) {
            lexicalOrderedSet.add(Integer.parseInt(currentNumStr));
        }
    };
}
