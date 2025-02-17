class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }

        Arrays.sort(nums);
        Integer firstIndex = 0, lastIndex = k - 1, min = Integer.MAX_VALUE;

        while (lastIndex < nums.length) {
            min = Math.min(min, nums[lastIndex++] - nums[firstIndex++]);
        }

        return min;
    }
}
