class Solution {
    public int subsetXORSum(int[] nums) {
        return computeXORs(nums, 0, 0);
    }

    private int computeXORs(int[] nums, int currentIndex, int currentXOR) {
        if (currentIndex == nums.length) {
            return currentXOR;
        }

        // Consider current element
        int xorWhenElementIsConsidered = computeXORs(nums, currentIndex + 1, currentXOR ^ nums[currentIndex]);

        // Ignore current element
        int xorWhenElementIsIgnored = computeXORs(nums, currentIndex + 1, currentXOR);

        return xorWhenElementIsConsidered + xorWhenElementIsIgnored;
    }
}
