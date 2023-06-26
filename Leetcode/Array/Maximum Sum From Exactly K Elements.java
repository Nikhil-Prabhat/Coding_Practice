class Solution {
    public int maximizeSum(int[] nums, int k) {
        // The following sequence generated will make an AP, we can directly get the sum of it
        Arrays.sort(nums);
        int maxElement = nums[nums.length - 1];
        int sum = (int) ((k/2.0) * (2 * maxElement + (k - 1)));
        return sum; 
    }
}