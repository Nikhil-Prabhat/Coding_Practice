class Solution {

    Set<List<Integer>> permutationListSet = new HashSet<>();
    List<List<Integer>> permutationList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        generatePermuation(nums, new ArrayList<>(), new boolean[nums.length]);
        permutationListSet.stream()
                .forEach(permutationList::add);
        return permutationList;
    }

    private void generatePermuation(int[] nums, List<Integer> intermediateList, boolean[] visited) {
        if (intermediateList.size() == nums.length) {
            permutationListSet.add(new ArrayList<>(intermediateList));
            return;
        }

        IntStream.range(0, nums.length)
                .forEach(permIndex -> {
                    if (!visited[permIndex]) {
                        visited[permIndex] = true;
                        intermediateList.add(nums[permIndex]);
                        generatePermuation(nums, intermediateList, visited);
                        visited[permIndex] = false;
                        intermediateList.remove(intermediateList.size() - 1);
                    }
                });

    }
}
