 public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tempMatrix = new int[m][n];

        if(k == 0)
            return createResultMatrix(grid);

        while (k > 0)
        {
            for(int i=0;i<tempMatrix.length;i++)
            {
                Arrays.fill(tempMatrix[i],0);
            }

            for(int i=0;i<m;i++)
            {
                for(int j=n-1;j>0;j--)
                {
                    try {
                        tempMatrix[i][j] = grid[i][j - 1];
                        tempMatrix[i + 1][0] = grid[i][n - 1];
                    }
                    catch(Exception ex)
                    {
                        continue;
                    }
                }
            }
            tempMatrix[0][0] = grid[m-1][n-1];
            for(int q = 0;q<m;q++)
            {
                for(int s = 0;s<n;s++)
                {
                    grid[q][s] = tempMatrix[q][s];
                }
            }
            k--;
        }

        return createResultMatrix(tempMatrix);
    }

    private List<List<Integer>> createResultMatrix(int[][] tempMatrix)
    {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<tempMatrix.length;i++)
        {
            result.add(new ArrayList<>());
            for(int j=0;j<tempMatrix[0].length;j++)
                result.get(i).add(tempMatrix[i][j]);
        }

        return result;
    }