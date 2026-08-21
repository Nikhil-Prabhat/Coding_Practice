class Solution {
    public int diagonalPrime(int[][] nums) {
        var maxPrimeNumber = Integer.MIN_VALUE;

        // Left to Right Diagonal
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i][i])) {
                if (maxPrimeNumber < nums[i][i]) {
                    maxPrimeNumber = nums[i][i];
                }
            }

        }

        // Right to Left Diagonal
        var j = nums[0].length - 1;
        for (int i = 0; i < nums.length; i++, j--) {
            if (isPrime(nums[i][j])) {
                if (maxPrimeNumber < nums[i][j]) {
                    maxPrimeNumber = nums[i][j];
                }
            }
        }

        return maxPrimeNumber != Integer.MIN_VALUE ? maxPrimeNumber : 0;
    }

    private boolean isPrime(int num) {
        var squareRootedNum = (int) Math.sqrt(num);

        if (num == 1) {
            return false;
        } else if (num == 2) {
            return true;
        }

        for (int i = 2; i <= squareRootedNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
