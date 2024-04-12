class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                if (isSubArrayIncreasing(nums, i, j))
                    count++;
            }
        }

        return count;
    }


    private boolean isSubArrayIncreasing(int[] nums, int start, int end) {
        int prev = Integer.MIN_VALUE;

        for (int k = 0; k < nums.length; k++) {
            if (k >= start && k <= end) {
                continue;
            }

            if (nums[k] <= prev) {
                return false;
            }

            prev = nums[k];
        }

        return true;
    }
}