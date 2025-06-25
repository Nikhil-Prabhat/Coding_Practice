class Solution {
    public int jump(int[] nums) {
        int numsLen = nums.length;
        int[] memoizedArr = new int[numsLen];
        Arrays.fill(memoizedArr, -1);
        return computeMinJumps(nums, 0, memoizedArr);
    }

    private int computeMinJumps(int[] nums, int index, int[] memoizedArr) {
        var numsLen = nums.length;

        if (index >= numsLen - 1) {
            return 0;
        }

        if (memoizedArr[index] != -1) {
            return memoizedArr[index];
        }

        int maxJump = nums[index];
        int minSteps = Integer.MAX_VALUE;

        for (int j = 1; j <= maxJump && index + j < numsLen; j++) {
            int jumps = computeMinJumps(nums, index + j, memoizedArr);
            if (jumps != Integer.MAX_VALUE) {
                minSteps = Math.min(minSteps, 1 + jumps);
            }
        }

        memoizedArr[index] = minSteps;
        return minSteps;
    }
}
