class Solution {
     public int minimumPairRemoval(int[] nums) {
        int numsLen = nums.length;
        int stepsCount = 0;

        while (numsLen > 0) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            boolean isAscending = true;

            for (int i = 0; i < numsLen - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    isAscending = false;
                }

                if (nums[i] + nums[i + 1] < minSum) {
                    minSum = nums[i] + nums[i + 1];
                    minIndex = i;
                }

            }

            if (isAscending) {
                break;
            }

            nums[minIndex] = minSum;
            for (int i = minIndex + 1; i < numsLen - 1; i++) {
                nums[i] = nums[i + 1];
            }

            numsLen--;
            stepsCount++;
        }

        return stepsCount;
    }
}
