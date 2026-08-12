class Solution {
    int[][] uniquePathDPArr;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        var rowLength = obstacleGrid.length;
        var colLength = obstacleGrid[0].length;
        uniquePathDPArr = new int[rowLength][colLength];

        IntStream.range(0, rowLength)
                .forEach(index -> Arrays.fill(uniquePathDPArr[index], -1));

        return countUniquePath(obstacleGrid, 0, 0, rowLength, colLength);
    }

    private int countUniquePath(int[][] obstracleGrid, int currentX, int currentY, int rowLength, int colLength) {
        // Case: Obstacle
        if (obstracleGrid[currentX][currentY] == 1) {
            return 0;
        }

        // Case : If we have non negative value in the dp array
        if (uniquePathDPArr[currentX][currentY] != -1) {
            return uniquePathDPArr[currentX][currentY];
        }

        // Case : If we have reached the final cell
        if (currentX == rowLength - 1 && currentY == colLength - 1) {
            return 1;
        }

        // Move right
        int rightPathCount = 0;
        if (currentY + 1 < colLength) {
            rightPathCount = countUniquePath(obstracleGrid, currentX, currentY + 1, rowLength, colLength);
        }

        // Move down
        int downPathCount = 0;
        if (currentX + 1 < rowLength) {
            downPathCount = countUniquePath(obstracleGrid, currentX + 1, currentY, rowLength, colLength);
        }

        uniquePathDPArr[currentX][currentY] = rightPathCount + downPathCount;
        return uniquePathDPArr[currentX][currentY];
    }
}
