class Solution {
    public int unequalTriplets(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (checkUniqueTripletConstraint(nums[i], nums[j], nums[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean checkUniqueTripletConstraint(int a, int b, int c) {
        return (a != b) && (b != c) && (c != a);
    }
}