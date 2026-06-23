class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        var isZeroFound = false;
        var smallestNum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k-- > 0) {
                nums[i] = Math.abs(nums[i]);
            }

            if (smallestNum > nums[i]) {
                smallestNum = nums[i];
            }

            if (nums[i] == 0) {
                isZeroFound = true;
            }
        }

        int totalArraySum = Arrays.stream(nums)
                .sum();

        return k <= 0 ? totalArraySum
                : ((isZeroFound) ? totalArraySum : (k % 2 == 0 ? totalArraySum : totalArraySum - (smallestNum * 2)));
    }
}
