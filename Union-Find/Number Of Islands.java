class Solution {
    private void iterateGrid(int currentRow, int currentColumn, char[][] grid, boolean[][] visited) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        visited[currentRow][currentColumn] = true;

        // Movements initialisers in all directions
        int[] rowMovement = {1, -1, 0, 0};
        int[] columnMovement = {0, 0, -1, 1};

        for (int i = 0; i < rowMovement.length; i++) {
            int newRow = rowMovement[i] + currentRow;
            int newColumn = columnMovement[i] + currentColumn;

            // Check if the adjacent cells are within boundries, unvisited and contains land
            if (newRow >= 0 && newRow < rowCount && newColumn >= 0 && newColumn < columnCount && !visited[newRow][newColumn] && grid[newRow][newColumn] == '1') {
                iterateGrid(newRow, newColumn, grid, visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int numOfIslandsCount = 0;
        int totalRowCount = grid.length;
        int totalColumnCount = grid[0].length;

        boolean[][] visited = new boolean[totalRowCount][totalColumnCount];

        for (int i = 0; i < totalRowCount; i++) {
            for (int j = 0; j < totalColumnCount; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    iterateGrid(i, j, grid, visited);
                    numOfIslandsCount++;
                }
            }
        }
        
        return numOfIslandsCount;
    }
}