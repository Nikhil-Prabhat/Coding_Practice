class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        var sumOfNums = Arrays.stream(nums).reduce(0, Integer::sum);
        var target = sumOfNums / k;

        if (sumOfNums % k != 0) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        return backtrackAllSubsets(0, k, 0, nums, target, used);
    }

    private boolean backtrackAllSubsets(int currentIndex, int k, int currentSubsetSum, int[] nums, int target,
            boolean[] used) {
        if (k == 0) {
            return true;
        }

        if (currentSubsetSum == target) {
            return backtrackAllSubsets(0, k - 1, 0, nums, target, used);
        }

        for (int i = currentIndex; i < nums.length; i++) {
            if (used[i] || currentSubsetSum + nums[i] > target) {
                continue;
            }

            used[i] = true;

            if (backtrackAllSubsets(i + 1, k, currentSubsetSum + nums[i], nums, target, used)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}
