class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0]) {
            return findIndexWhenIteratedFromBack(nums, target);
        } else if (target > nums[0]) {
            return findIndexWhenIteratedFromFront(nums, target);
        }

        return 0;
    }

    private int findIndexWhenIteratedFromFront(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; i++) {
            if (nums[i] == target) {
                return i;
            }

            if ((nums[i + 1] < nums[i])) {
                return -1;
            }
        }

        return nums[numsLength - 1] == target ? numsLength - 1 : -1;
    }

    private int findIndexWhenIteratedFromBack(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = numsLength - 1; i > 0; i--) {
            if (nums[i] == target) {
                return i;
            }

            if ((nums[i] < nums[i - 1])) {
                return -1;
            }
        }

        return nums[numsLength - 1] == target ? numsLength - 1 : -1;
    }
}
