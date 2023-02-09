class Solution {
    public int numSpecial(int[][] mat) {
        int specialPosition = 0;
        int row = mat.length;
        int column = mat[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 1)
                    specialPosition = checkIfSpeicalPositionExists(i, j, row, column, mat) ? specialPosition + 1 : specialPosition;
            }
        }

        return specialPosition;
    }

    private boolean checkIfSpeicalPositionExists(int i, int j, int row, int column, int[][] mat) {
        int countOfOneInRow = 0;
        int countOfOneInColumn = 0;

        // For fixed row
        for (int k = 0; k < column; k++) {
            if (mat[i][k] == 1)
                countOfOneInRow++;
        }

        // For fixed column
        for (int k = 0; k < row; k++) {
            if (mat[k][j] == 1)
                countOfOneInColumn++;
        }

        return countOfOneInColumn == 1 &&  countOfOneInRow == 1;

    }

}