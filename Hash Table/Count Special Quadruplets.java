class Solution {
    public int countQuadruplets(int[] nums) {
        int firstIndex, secondIndex, thirdIndex, fourthIndex, numsLength = nums.length, count = 0;

        for (firstIndex = 0; firstIndex < numsLength - 3; firstIndex++) {
            for (secondIndex = firstIndex + 1; secondIndex < numsLength - 2; secondIndex++) {
                for (thirdIndex = secondIndex + 1; thirdIndex < numsLength - 1; thirdIndex++) {
                    for (fourthIndex = thirdIndex + 1; fourthIndex < numsLength; fourthIndex++) {
                        if (nums[firstIndex] + nums[secondIndex] + nums[thirdIndex] == nums[fourthIndex]) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
