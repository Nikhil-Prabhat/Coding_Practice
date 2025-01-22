class Solution {
    public int integerReplacement(int n) {
        int[] memoizedTable = new int[n + 2];
        Arrays.fill(memoizedTable, -1);
        memoizedTable[1] = 0;

        return computeIntegerReplacement(memoizedTable, n);
    }

    private int computeIntegerReplacement(int[] memoizedTable, int n) {
        // Base case
        if (n == 1) {
            return 0;
        }

        if (memoizedTable[n] != -1) {
            return memoizedTable[n];
        }

        if (n % 2 == 0) {
            memoizedTable[n] = 1 + computeIntegerReplacement(memoizedTable, n / 2);
        } else {
            memoizedTable[n] = 1 + Math.min(computeIntegerReplacement(memoizedTable, n - 1),
                    computeIntegerReplacement(memoizedTable, n + 1));
        }

        return memoizedTable[n];
    }
}

