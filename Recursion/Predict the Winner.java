class Solution {

    int[][] memoizationTable;
    
    public boolean predictTheWinner(int[] nums) {
        memoizationTable = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memoizationTable[i], -1);
        }

        return helperForWinnerPrediction(nums, 0, nums.length - 1) >= 0;
    }

    private int helperForWinnerPrediction(int[] nums, int startIndex, int endIndex) {
        if (memoizationTable[startIndex][endIndex] != -1)
            return memoizationTable[startIndex][endIndex];

        if (startIndex == endIndex)
            return nums[startIndex];

        int leftChoiceResult = nums[startIndex] - helperForWinnerPrediction(nums, startIndex + 1, endIndex);
        int rightChoiceResult = nums[endIndex] - helperForWinnerPrediction(nums, startIndex, endIndex - 1);

        memoizationTable[startIndex][endIndex] = Math.max(leftChoiceResult, rightChoiceResult);

        return memoizationTable[startIndex][endIndex];
    }
}