class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memoizedTable = new int[m][n];
        IntStream.range(0, m)
                .forEach(index -> Arrays.fill(memoizedTable[index], -1));

        return computeUniquePaths(0, 0, m, n, memoizedTable);
    }

    private int computeUniquePaths(int currentRow, int currentColumn, int rowLen, int colLen, int[][] memoizedTable) {
        // Base Condition
        if (currentRow == rowLen-1 && currentColumn == colLen-1) {
            return 1;
        }

        // Bounding Condition
        if (currentRow < 0 || currentRow >= rowLen || currentColumn < 0 || currentColumn >= colLen) {
            return 0;
        }

        if (memoizedTable[currentRow][currentColumn] != -1) {
            return memoizedTable[currentRow][currentColumn];
        }

        int rightPossibleWays = computeUniquePaths(currentRow, currentColumn + 1, rowLen, colLen, memoizedTable);
        int downPossibleWays = computeUniquePaths(currentRow + 1, currentColumn, rowLen, colLen, memoizedTable);

        return memoizedTable[currentRow][currentColumn] = rightPossibleWays + downPossibleWays;
    }
}
