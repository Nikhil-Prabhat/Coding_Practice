class Solution {
    public boolean checkValid(int[][] matrix) {
        BitSet matrixBitSet = new BitSet();
        for (int i = 0; i < matrix.length; i++) {
            setRowBitsForMatrix(matrix, matrixBitSet, i);
            boolean allBitsFound = checkIfAllBitsFound(matrixBitSet, matrix.length);

            if (!allBitsFound) {
                return false;
            }

            matrixBitSet.clear();
        }

        for (int i = 0; i < matrix.length; i++) {
            setColBitsForMatrix(matrix, matrixBitSet, i);
            boolean allBitsFound = checkIfAllBitsFound(matrixBitSet, matrix.length);

            if (!allBitsFound) {
                return false;
            }

            matrixBitSet.clear();
        }

        return true;
    }

    private void setRowBitsForMatrix(int[][] matrix, BitSet matrixBitSet, int row) {
        for (int i = 0; i < matrix.length; i++) {
            matrixBitSet.set(matrix[row][i]);
        }
    }

    private void setColBitsForMatrix(int[][] matrix, BitSet matrixBitSet, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrixBitSet.set(matrix[i][col]);
        }
    }

    private boolean checkIfAllBitsFound(BitSet matrixBitSet, int matrixLen) {
        for (int i = 0; i < matrixLen; i++) {
            if (!matrixBitSet.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
