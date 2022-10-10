public class LeetCode {

    public static void main(String[] args) {
        LeetCode leetcode = new LeetCode();

        int[][] grid = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,2,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };

        int[][] largestLocal = leetcode.largestLocal(grid);
        System.out.println(Arrays.deepToString(largestLocal));


    }

public int[][] largestLocal(int[][] grid) {
        int lengthOfGrid = grid.length;
        int[][] resultMatrix = new int[lengthOfGrid - 2][lengthOfGrid - 2];
        int k = 0, m = 0;

        for (int i = 0; i < i + 3 && i+3 <= lengthOfGrid; i++) {
            for (int j = 0; j < j + 3 && j+3 <= lengthOfGrid; j++) {
                int maxNumber = findLargestNumberInMatrix(i, j, grid);
                resultMatrix[k][m] = maxNumber;
                //Increase the index for the inner loop
                m++;
            }
            //Increase the index for the outer loop
            k++;
            m = 0;
        }

        return resultMatrix;

    }

    private int findLargestNumberInMatrix(int i, int j, int[][] matrix) {
        int maxNumber = Integer.MIN_VALUE;

        for (int x = i; x < i + 3; x++)
            for (int y = j; y < j + 3; y++)
                maxNumber = Math.max(maxNumber, matrix[x][y]);

        return maxNumber;
    }
