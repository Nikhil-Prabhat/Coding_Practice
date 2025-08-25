class Solution {

    // CASE 1 : When maximum sum is non-circular : Standard Kadene Algorithm
    // CASE 2 : When maximum sum is circular : Total sum - Minimum Sum
    // CASE 3 : When all numbers are negative : Standard Kadene Algorithm
    public int maxSubarraySumCircular(int[] nums) {
        int currentMinimum = nums[0], currentMaximum = nums[0], minimumSum = nums[0], maximumSum = nums[0], totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Find maximum
            currentMaximum = Math.max(nums[i], currentMaximum + nums[i]);
            maximumSum = Math.max(maximumSum, currentMaximum);

            // Find minimum
            currentMinimum = Math.min(nums[i], currentMinimum + nums[i]);
            minimumSum = Math.min(currentMinimum, minimumSum);

            // Total Sum
            totalSum += nums[i];
        }

        return minimumSum == totalSum ? maximumSum : Math.max(maximumSum, totalSum - minimumSum);
    }
}
