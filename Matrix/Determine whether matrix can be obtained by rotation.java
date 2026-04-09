class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int maxRotations = 4;

        while (maxRotations-- > 0) {
            if (isMatrixEqual(mat, target)) {
                return true;
            }

            rotateMatrix(mat);
        }

        return false;
    }

    public void rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    private boolean isMatrixEqual(int[][] sourceMatrix, int[][] targetMatrix) {
        for (int i = 0; i < sourceMatrix.length; i++) {
            for (int j = 0; j < sourceMatrix.length; j++) {
                if (sourceMatrix[i][j] != targetMatrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
