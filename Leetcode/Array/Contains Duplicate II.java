class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> numsWithIndicesMap = new HashMap<>();

        IntStream.range(0, nums.length).forEach(
                index -> {
                    List<Integer> numIndicesInArr = numsWithIndicesMap.getOrDefault(nums[index], new ArrayList<>());
                    numIndicesInArr.add(index);
                    numsWithIndicesMap.put(nums[index], numIndicesInArr);
                });

        BiPredicate<Integer, Integer> differencePredicate = (index1, index2) -> Math.abs(index1 - index2) <= k;

        return numsWithIndicesMap.entrySet().stream()
                .anyMatch(entry -> {
                    List<Integer> indices = entry.getValue();
                    return IntStream.range(0, indices.size())
                            .anyMatch(i -> IntStream.range(i + 1, indices.size())
                                    .anyMatch(j -> differencePredicate.test(indices.get(i), indices.get(j))));
                });
    }
}
