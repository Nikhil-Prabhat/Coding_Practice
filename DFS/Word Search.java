record RowColPair(int row, int col) {
};

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        IntStream.range(0, board.length)
                .forEach(index -> Arrays.fill(visited[index], false));

        for (int i = 0; i < board.length; i++) {
            for (int j = i; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ifWordPresent = iterateBoardByDFS(board, visited, new RowColPair(i, j), "", word);
                    if (ifWordPresent) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean iterateBoardByDFS(char[][] board, boolean[][] visited, RowColPair rowColPair, String currentString,
            String word) {
        int rowLen = board.length;
        int colLen = board[0].length;
        int row = rowColPair.row();
        int col = rowColPair.col();
        boolean isFound;

        // Base Case
        if ((row >= 0 && row < rowLen) && (col >= 0 && col < colLen)) {
            if (!visited[row][col]) {

                visited[row][col] = true;
                currentString += board[row][col];

                if (!word.contains(currentString)) {
                    visited[row][col] = false;
                    return false;
                } else if (currentString.equals(word)) {
                    return true;
                }

                isFound = iterateBoardByDFS(board, visited, new RowColPair(row - 1, col), currentString, word);
                if (isFound)
                    return true;

                isFound = iterateBoardByDFS(board, visited, new RowColPair(row + 1, col), currentString, word);
                if (isFound)
                    return true;

                isFound = iterateBoardByDFS(board, visited, new RowColPair(row, col - 1), currentString, word);
                if (isFound)
                    return true;

                isFound = iterateBoardByDFS(board, visited, new RowColPair(row, col + 1), currentString, word);
                if (isFound)
                    return true;

                // Check this condition to check the boolean
                visited[row][col] = false;
            }
        }
        return false;
    }
}
