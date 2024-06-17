class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalResultList = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        iterateAllCombinations(1, combination, finalResultList, n, k);
        return finalResultList;
    }

    private void iterateAllCombinations(int start, List<Integer> combination, List<List<Integer>> finalResultList, int end, int maxAllowedSize) {
        if (combination.size() == maxAllowedSize) {
            finalResultList.add(new ArrayList<>(combination));
            return;
        }

        IntStream.range(start, end + 1)
                .forEach(
                        currentNumber -> {
                            combination.add(currentNumber);
                            iterateAllCombinations(currentNumber + 1, combination, finalResultList, end, maxAllowedSize);
                            combination.remove(combination.size() - 1);
                        }
                );
    }
}