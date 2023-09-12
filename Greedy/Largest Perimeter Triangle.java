class Solution {
   public int largestPerimeter(int[] nums) {
        int maxPerimeter = 0;
        Integer[] nums_updated = new Integer[nums.length];
        Arrays.setAll(nums_updated, i -> nums[i]);
        Arrays.sort(nums_updated, Collections.reverseOrder());

        for (int i = 0; i < nums_updated.length - 2; i++) {
            if (checkIfTriangleIsPossible(nums_updated[i], nums_updated[i + 1], nums_updated[i + 2])) {
                int perimeterOfCurrentTriangle = nums_updated[i] + nums_updated[i+1] + nums_updated[i+2];
                maxPerimeter = maxPerimeter < perimeterOfCurrentTriangle ? perimeterOfCurrentTriangle : maxPerimeter;
            }
        }

        return maxPerimeter;

    }

    private boolean checkIfTriangleIsPossible(int firstSide, int secondSide, int thirdSide) {
        return (firstSide + secondSide > thirdSide) && (firstSide + thirdSide > secondSide) && (secondSide + thirdSide > firstSide);
    }
}