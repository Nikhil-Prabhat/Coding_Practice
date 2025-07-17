class Solution {

    String[][] ticTacToeArr = new String[3][3];
    
    public String tictactoe(int[][] moves) {
        prepareTicTacToeArr(moves);
        return findTheGameResult(moves);
    }

    private boolean checkRowWise(int rowNo, String playerChar) {
        for (int i = 0; i < 3; i++) {
            if (!ticTacToeArr[rowNo][i].equals(playerChar)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkColumnWise(int colNo, String playerChar) {
        for (int i = 0; i < 3; i++) {
            if (!ticTacToeArr[i][colNo].equals(playerChar)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonally(String playerChar) {
        if (ticTacToeArr[0][0].equals(playerChar) && ticTacToeArr[1][1].equals(playerChar)
                && ticTacToeArr[2][2].equals(playerChar))
            return true;

        if (ticTacToeArr[0][2].equals(playerChar) && ticTacToeArr[1][1].equals(playerChar)
                && ticTacToeArr[2][0].equals(playerChar))
            return true;

        return false;
    }

    private void prepareTicTacToeArr(int[][] moves) {
        IntStream.range(0, 3)
                .forEach(index -> Arrays.fill(ticTacToeArr[index], "-"));

        for (int i = 0; i < moves.length; i++) {
            var index = moves[i];
            if (i % 2 == 0) {
                ticTacToeArr[index[0]][index[1]] = "X";
            } else {
                ticTacToeArr[index[0]][index[1]] = "O";
            }
        }
    }

    private String findTheGameResult(int[][] moves) {
        for (int i = 0; i < 3; i++) {
            if (checkRowWise(i, "X") || checkColumnWise(i, "X")) {
                return "A";
            }

            if (checkRowWise(i, "O") || checkColumnWise(i, "O")) {
                return "B";
            }
        }

        // Check for diagonals
        if (checkDiagonally("X")) {
            return "A";
        } else if (checkDiagonally("O")) {
            return "B";
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
