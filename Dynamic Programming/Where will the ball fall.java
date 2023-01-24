public int[] findBall(int[][] grid) {
        int[] exitColumns = new int[grid[0].length];

        for (int col = 0; col < grid[0].length; col++) {
            exitColumns[col] = dfs(grid, 0, col);
        }

        return exitColumns;
    }

    private int dfs(int[][] grid, int row, int col) {

        // ball dropped out of box or hit wall of the box
        if (row > grid.length || col < 0 || col >= grid[0].length) {
            return -1;
        }

        // ball reach at the end of the box
        if (row == grid.length) {
            return col;
        }

        // find "V" shaped pattern
        if (grid[row][col] == 1) {
            if (col < grid[0].length - 1 && grid[row][col] != grid[row][col + 1]) {
                return -1;
            }
        } else {
            if (col > 0 && grid[row][col - 1] != grid[row][col]) {
                return -1;
            }
        }

        //if grid[row][col] = 1, redirect ball to the right o/w left
        col += grid[row][col];

        //recure till box dropped out of box or get stuck in V shap or at wall boundary
        return dfs(grid, row + 1, col);
    }