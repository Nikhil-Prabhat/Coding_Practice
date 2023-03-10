class Solution {
    public int[] leftRigthDifference(int[] nums) {

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int leftSum = findLeftSum(nums, i);
            int rightSum = findRightSum(nums, i);
            int absDiff = Math.abs(leftSum - rightSum);
            answer[i] = absDiff;
        }

        return answer;

    }

    private int findLeftSum(int[] nums, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += nums[i];
        }

        return sum;
    }

    private int findRightSum(int[] nums, int index) {
        int sum = 0;
        for (int i = nums.length - 1; i > index; i--) {
            sum += nums[i];
        }

        return sum;
    }
}