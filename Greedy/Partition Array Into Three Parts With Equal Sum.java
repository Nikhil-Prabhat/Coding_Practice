class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int total = 0;
        int count = 0;
        int sum = 0;
        for (int num : arr) {
            total += num;
        }

        if (total % 3 != 0) return false;

        int target = total / 3;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == target) {
                count++;
                sum = 0;
            }
        }

        return count >= 3;
    }
}

// Tried Solution
class Solution {
    record SumAndIndex(int sum, int index) {
    };

    public boolean canThreePartsEqualSum(int[] arr) {
        int arrSum = Arrays.stream(arr).sum();
        if (arrSum % 3 != 0) {
            return false;
        }
        var sumOfEachPart = arrSum / 3;

        SumAndIndex firstPart = computeSumAndGetLastIndex(arr, sumOfEachPart, 0, 0);
        if (!checkIfCalculatedSumIsEqualToExpectedSum.test(firstPart.sum(), sumOfEachPart)) {
            return false;
        }

        SumAndIndex secondPart = computeSumAndGetLastIndex(arr, sumOfEachPart, 0, firstPart.index());
        if (!checkIfCalculatedSumIsEqualToExpectedSum.test(secondPart.sum(), sumOfEachPart)) {
            return false;
        }

        SumAndIndex thirdPart = computeSumAndGetLastIndex(arr, sumOfEachPart, 0, secondPart.index());
        if (!checkIfCalculatedSumIsEqualToExpectedSum.test(thirdPart.sum(), sumOfEachPart)) {
            return false;
        }

        return thirdPart.index() == arr.length;
    }

    private SumAndIndex computeSumAndGetLastIndex(int[] arr, int sumOfEachPart, int tempSum, int index) {
        while ((index < arr.length) && (tempSum != sumOfEachPart)) {
            tempSum += arr[index];
            index++;
        }

        return new SumAndIndex(tempSum, index);
    }

    private BiPredicate<Integer, Integer> checkIfCalculatedSumIsEqualToExpectedSum = (calculatedSum,
            expectedSum) -> calculatedSum == expectedSum;
}
