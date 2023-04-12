class CustomIndex {

    int i;
    int j;

    public CustomIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomIndex)) return false;
        CustomIndex that = (CustomIndex) o;
        return getI() == that.getI() && getJ() == that.getJ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getI(), getJ());
    }

    @Override
    public String toString() {
        return "CustomIndex{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}


class Solution {
    public int countBattleships(char[][] board) {

        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Character.compare(board[i][j], 'X') == 0)
                    iterateBattleShip(board, ++count, new CustomIndex(i, j));
                continue;
            }
        }

        return count;
    }

    private void iterateBattleShip(char[][] board, int count, CustomIndex index) {
        int i = index.getI();
        int j = index.getJ();
        board[i][j] = '.';
        Stack<CustomIndex> indexStack = new Stack<>();
        String directionToProceed = "";

        // Decide the direction of battleship i.e horizontal or vertical
        try {
            if (Character.compare(board[i][j + 1], 'X') == 0) {
                indexStack.push(new CustomIndex(i, j + 1));
                directionToProceed = "right";
            }
        } catch (Exception ex) {
            // Don't do anything
        }

        try {
            if (Character.compare(board[i + 1][j], 'X') == 0) {
                indexStack.push(new CustomIndex(i + 1, j));
                directionToProceed = "down";
            }
        } catch (Exception ex) {
            // Don't do anything
        }

        //Find all the compartments of the battleship
        while (!indexStack.isEmpty()) {
            CustomIndex topIndex = indexStack.pop();
            int topIndexI = topIndex.getI();
            int topIndexJ = topIndex.getJ();

            if (topIndexI < board.length && topIndexJ < board[0].length && Character.compare(board[topIndexI][topIndexJ], 'X') == 0) {
                board[topIndexI][topIndexJ] = '.';
                CustomIndex newCustomIndex = directionToProceed.equals("right") ? new CustomIndex(topIndexI, topIndexJ + 1) : new CustomIndex(topIndexI + 1, topIndexJ);
                indexStack.push(newCustomIndex);
            }
        }
    }
}