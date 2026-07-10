class Solution {
    // memoized[n] : Number of squares it takes to reach n
    public int numSquares(int n) {
        int[] memoizedTable = new int[n + 2];
        Arrays.fill(memoizedTable, n);
        memoizedTable[0] = 0;

        // This is the actual range of the target
        for (int i = 1; i < n + 1; i++) {

            // Start from the least number and check, with that num, what is the best possibility
            for (int j = 1; j < i + 1; j++) {
                var squareNum = j * j;
                if (i - squareNum < 0) {
                    break;
                }

                memoizedTable[i] = Math.min(memoizedTable[i], 1 + memoizedTable[i - squareNum]);
            }
        }

        return memoizedTable[n];
    }
}
