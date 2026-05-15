class Solution {

    int MODULO = (int) (1e9 + 7);
    long[][] combinationTable;

    public int numOfWays(int[] nums) {
        combinationTable = new long[nums.length][nums.length];
        initCombinationTable(combinationTable, nums.length);
        List<Integer> numsList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        return (int) ((calculateNoOfWays(numsList) - 1) % MODULO);
    }

    private long calculateNoOfWays(List<Integer> numList) {
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();

        if (numList.size() < 3) {
            return 1;
        }

        IntStream.range(1, numList.size()).forEach(
                index -> {
                    int currentNodeElement = numList.get(index);
                    if (currentNodeElement < numList.get(0)) {
                        leftNodes.add(currentNodeElement);
                    } else {
                        rightNodes.add(currentNodeElement);
                    }
                });

        long totalNoOfLeftWays = calculateNoOfWays(leftNodes) % MODULO;
        long totalNoOfRightWays = calculateNoOfWays(rightNodes) % MODULO;

        return ((totalNoOfLeftWays * totalNoOfRightWays) % MODULO)
                * (combinationTable[numList.size() - 1][leftNodes.size()] % MODULO);
    }

    private void initCombinationTable(long[][] combinationTable, int numLength) {
        IntStream.range(0, numLength)
                .forEach(index -> {
                    combinationTable[index][0] = combinationTable[index][index] = 1;
                });

        IntStream.range(2, numLength).forEach(
                firstIndex -> {
                    IntStream.range(1, firstIndex).forEach(
                            secondIndex -> combinationTable[firstIndex][secondIndex] = (combinationTable[firstIndex
                                    - 1][secondIndex - 1] + combinationTable[firstIndex - 1][secondIndex]) % MODULO);
                });
    }
}
