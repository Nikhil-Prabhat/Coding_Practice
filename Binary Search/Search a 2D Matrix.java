// Accepted Solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var rows = matrix.length;
        var cols = matrix[0].length;
        var firstIndex = 0;
        var lastIndex = (rows * cols) - 1;

        while (firstIndex <= lastIndex) {
            var midIndex = firstIndex + (lastIndex - firstIndex) / 2;

            var actualRow = midIndex / cols;
            var actualColumn = midIndex % cols;

            if (matrix[actualRow][actualColumn] == target) {
                return true;
            } else if (matrix[actualRow][actualColumn] < target) {
                firstIndex = midIndex + 1;
            } else {
                lastIndex = midIndex - 1;
            }
        }

        return false;
    }
}

// Tried Solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowToSearch = findRowToSearch(matrix, target);
        return rowToSearch == -1 ? false : binarySearch(matrix[rowToSearch], target);
    }

    private int findRowToSearch(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][0] <= target && matrix[i + 1][0] >= target) {
                return i;
            }
        }

        return -1;
    }

    private boolean binarySearch(int[] matrixRow, int target) {
        int firstIndex = 0;
        int lastIndex = matrixRow.length - 1;

        while (firstIndex <= lastIndex) {
            var midIndex = (firstIndex + lastIndex) / 2;

            if (matrixRow[midIndex] == target) {
                return true;
            } else if (matrixRow[midIndex] > target) {
                lastIndex = midIndex - 1;
            } else {
                firstIndex = midIndex + 1;
            }
        }

        return false;
    }
}
