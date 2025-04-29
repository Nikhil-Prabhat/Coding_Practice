class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int count = 0;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                count++;
            }
        }

        return (nums[len - 2] == 1 && nums[len - 1] == 1) ? count : -1;
    }
}
