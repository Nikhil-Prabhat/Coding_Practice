class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int[][] resultMatrix = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == -1) {
                    resultMatrix[i][j] = findLargestNumberInTheColumn(j, rowLength, matrix);
                } else {
                    resultMatrix[i][j] = matrix[i][j];
                }
            }
        }

        return resultMatrix;
    }

    private int findLargestNumberInTheColumn(int column, int rowLength, int[][] matrix) {
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][column] > maxNum) {
                maxNum = matrix[i][column];
            }
        }

        return maxNum;
    }
}