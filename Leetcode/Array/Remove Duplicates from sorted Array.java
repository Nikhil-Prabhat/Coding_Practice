class Solution {
    Integer arrIndex = 0;
    public int removeDuplicates(int[] nums) {
        Map<Integer, Boolean> nonDuplicateMap = new TreeMap<>();

        Arrays.stream(nums).forEach(
                num -> {
                    nonDuplicateMap.putIfAbsent(num, true);
                }
        );

        Arrays.fill(nums, -1);
        nonDuplicateMap.entrySet().forEach(
                entry -> {
                    nums[arrIndex++] = entry.getKey();
                }
        );

        return nonDuplicateMap.size();
    }
}
