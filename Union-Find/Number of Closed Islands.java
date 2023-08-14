class Solution {
    public int closedIsland(int[][] grid) {

        int rowCount = grid.length;
        int columnCount = grid[0].length;
        int count = 0;

        // To handle boundry condition
        for (int i = 0; i < rowCount; i++)
            for (int j = 0; j < columnCount; j++)
                if (i * j == 0 || i == rowCount - 1 || j == columnCount - 1)
                    if (grid[i][j] == 0)
                        iterateGraph(i, j, grid);

        // To calculate the island
        for (int i = 0; i < rowCount; i++)
            for (int j = 0; j < columnCount; j++)
                if (grid[i][j] == 0) {
                    count++;
                    iterateGraph(i, j, grid);
                }

        return count;

    }

    private void iterateGraph(int i, int j, int[][] graph) {
        int rowCount = graph.length;
        int columnCount = graph[0].length;

        if (i < 0 || i >= rowCount || j < 0 || j >= columnCount || graph[i][j] != 0) {
            return;
        }

        graph[i][j] = 1;
        iterateGraph(i + 1, j, graph);
        iterateGraph(i - 1, j, graph);
        iterateGraph(i, j + 1, graph);
        iterateGraph(i, j - 1, graph);
    }
}