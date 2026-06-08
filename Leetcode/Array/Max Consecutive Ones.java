class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        int tempCount = 0;

        for (int num : nums) {
            if (num == 1) {
                tempCount++;
            } else {
                maxCount = Math.max(tempCount, maxCount);
                tempCount = 0;
            }
        }

        return tempCount != 0 ? Math.max(tempCount, maxCount) : maxCount;
    }
}
