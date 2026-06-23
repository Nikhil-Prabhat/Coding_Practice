class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        var numLength = nums.length;

        return Math.max((nums[numLength - 1] * nums[numLength - 2] * nums[numLength - 3]),
                (nums[numLength - 1] * nums[0] * nums[1]));
    }
}
