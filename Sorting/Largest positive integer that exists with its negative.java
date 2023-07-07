class Solution {
    public int findMaxK(int[] nums) {
       Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if(nums[j] == -(nums[i]))
                        return nums[i];
                }
            }
        }
        return -1; 
    }
}