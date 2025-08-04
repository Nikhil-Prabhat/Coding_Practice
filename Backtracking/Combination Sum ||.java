class Solution {

    List<List<Integer>> combinationList = new ArrayList<>();
    List<List<Integer>> finalCombinationList = new ArrayList<>();
    Map<List<Integer>, Boolean> intermediateCombinationMap = new HashMap<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sumOfCandidates = Arrays.stream(candidates).reduce(0, Integer::sum);
        getCombinations(candidates, new ArrayList<>(), 0, target, 0, sumOfCandidates);

        combinationList.stream()
                .forEach(list -> {
                    Collections.sort(list);
                    if (!intermediateCombinationMap.containsKey(list)) {
                        intermediateCombinationMap.put(list, true);
                        finalCombinationList.add(list);
                    }
                });

        return finalCombinationList;
    }

    private void getCombinations(int[] candidatesArr, List<Integer> intermediateList, int index, int targetSum,
            int sumOfElementsSoFar, int remainingSumSoFar) {
        var tempIntermediateList = new ArrayList<>(intermediateList);
        if (targetSum == sumOfElementsSoFar) {
            combinationList.add(tempIntermediateList);
            return;
        }

        // Bounding condition
        if (sumOfElementsSoFar > targetSum || remainingSumSoFar <= 0 || index >= candidatesArr.length) {
            return;
        }

        // Consider without addition of current element
        getCombinations(candidatesArr, tempIntermediateList, index + 1, targetSum, sumOfElementsSoFar,
                remainingSumSoFar);

        // Consider with the addition of current element
        sumOfElementsSoFar += candidatesArr[index];
        remainingSumSoFar -= candidatesArr[index];

        tempIntermediateList.add(candidatesArr[index]);
        getCombinations(candidatesArr, tempIntermediateList, index + 1, targetSum, sumOfElementsSoFar,
                remainingSumSoFar);
    }
}
