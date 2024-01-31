class Solution {
    public int countServers(int[][] grid) {
        int communicatingServerCount = 0;
        int row = grid.length;
        int column = grid[0].length;
        int[][] tempGrid = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {

                    // iterate row
                    for (int k = 0; k < column; k++) {
                        if (k == j)
                            continue;

                        if (grid[i][k] == 1) {
                            tempGrid[i][k] = 2;
                            tempGrid[i][j] = 2;
                            break;
                        }
                    }

                    // iterate column
                    for (int k = 0; k < row; k++) {
                        if (k == i)
                            continue;

                        if (grid[k][j] == 1) {
                            tempGrid[k][j] = 2;
                            tempGrid[i][j] = 2;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tempGrid[i][j] == 2)
                    communicatingServerCount++;
            }
        }

        return communicatingServerCount;

    }
}