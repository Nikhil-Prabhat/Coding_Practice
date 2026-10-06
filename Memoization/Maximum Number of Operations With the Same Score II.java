// Without Memoization
class Solution {
    public int maxOperations(int[] nums) {
        return findMaxOperationWithSameSum(nums, 0);
    }

    private int findMaxOperationWithSameSum(int[] arr, int previousSum) {
        if (arr.length < 2) {
            return 0;
        }

        int sumWithFirstOperation = arr[0] + arr[1];
        int sumWithSecondOperation = arr[arr.length - 1] + arr[arr.length - 2];
        int sumWithThirdOperation = arr[0] + arr[arr.length - 1];

        int firstOperation = 0;
        int secondOperation = 0;
        int thirdOperation = 0;

        if (previousSum == 0 || sumWithFirstOperation == previousSum) {
            firstOperation = 1
                    + findMaxOperationWithSameSum(Arrays.copyOfRange(arr, 2, arr.length), sumWithFirstOperation);
        }

        if (previousSum == 0 || sumWithSecondOperation == previousSum) {
            secondOperation = 1
                    + findMaxOperationWithSameSum(Arrays.copyOfRange(arr, 0, arr.length - 2), sumWithSecondOperation);
        }

        if (previousSum == 0 || sumWithThirdOperation == previousSum) {
            thirdOperation = 1
                    + findMaxOperationWithSameSum(Arrays.copyOfRange(arr, 1, arr.length - 1), sumWithThirdOperation);
        }

        return Math.max(firstOperation, Math.max(secondOperation, thirdOperation));
    }
}

// With memoization
class Solution {
    Integer[][] memoizedTable;
    
    public int maxOperations(int[] nums) {
        memoizedTable = new Integer[nums.length][nums.length];

        int firstOperation = 1
                + findMaxOperationWithSameSum(nums, 2, nums.length - 1, nums[0] + nums[1], memoizedTable);
        int secondOperation = 1 + findMaxOperationWithSameSum(nums, 0, nums.length - 3,
                nums[nums.length - 2] + nums[nums.length - 1], memoizedTable);
        int thirdOperation = 1
                + findMaxOperationWithSameSum(nums, 1, nums.length - 2, nums[0] + nums[nums.length - 1], memoizedTable);

        return Math.max(firstOperation, Math.max(secondOperation, thirdOperation));
    }

    private int findMaxOperationWithSameSum(int[] arr, int leftIndex, int rightIndex, int previousSum,
            Integer[][] memoizedTable) {
        if (leftIndex >= rightIndex) {
            return 0;
        }

        if (Objects.nonNull(memoizedTable[leftIndex][rightIndex])) {
            return memoizedTable[leftIndex][rightIndex];
        }

        int firstOperation = 0;
        int secondOperation = 0;
        int thirdOperation = 0;

        if (arr[leftIndex] + arr[leftIndex + 1] == previousSum) {
            firstOperation = 1
                    + findMaxOperationWithSameSum(arr, leftIndex + 2, rightIndex, previousSum, memoizedTable);
        }

        if (arr[rightIndex] + arr[rightIndex - 1] == previousSum) {
            secondOperation = 1
                    + findMaxOperationWithSameSum(arr, leftIndex, rightIndex - 2, previousSum, memoizedTable);
        }

        if (arr[leftIndex] + arr[rightIndex] == previousSum) {
            secondOperation = 1
                    + findMaxOperationWithSameSum(arr, leftIndex + 1, rightIndex - 1, previousSum, memoizedTable);
        }

        memoizedTable[leftIndex][rightIndex] = Math.max(firstOperation, Math.max(secondOperation, thirdOperation));
        return memoizedTable[leftIndex][rightIndex];
    }
}

// Accepted Solution
class Solution {
    public int maxOperations(int[] nums) {
        int maxOperations = 0;
        int len = nums.length;
        int[][] memoization = new int[len][len];
        int start = 0;
        int end = len - 1;

        maxOperations = Math.max(maxOperations,
                findMaxOpsHelper(nums, start + 2, end, nums[start] + nums[start + 1], memoization) + 1);
        maxOperations = Math.max(maxOperations,
                findMaxOpsHelper(nums, start + 1, end - 1, nums[start] + nums[end], memoization) + 1);
        maxOperations = Math.max(maxOperations,
                findMaxOpsHelper(nums, start, end - 2, nums[end] + nums[end - 1], memoization) + 1);

        return maxOperations;
    }

    private int findMaxOpsHelper(int[] nums, int left, int right, int previousSum, int[][] memoization) {
        if (left >= right)
            return 0;
        if (memoization[left][right] != 0)
            return memoization[left][right];

        int maxOps = 0;
        if (nums[left] + nums[left + 1] == previousSum)
            maxOps = Math.max(maxOps, findMaxOpsHelper(nums, left + 2, right, previousSum, memoization) + 1);
        if (nums[left] + nums[right] == previousSum)
            maxOps = Math.max(maxOps, findMaxOpsHelper(nums, left + 1, right - 1, previousSum, memoization) + 1);
        if (nums[right] + nums[right - 1] == previousSum)
            maxOps = Math.max(maxOps, findMaxOpsHelper(nums, left, right - 2, previousSum, memoization) + 1);

        return memoization[left][right] = maxOps;
    }
}
