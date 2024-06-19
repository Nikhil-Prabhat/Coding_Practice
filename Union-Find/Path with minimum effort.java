class EffortNode {
    int row;
    int column;
    int effort;

    public EffortNode(int row, int column, int effort) {
        this.row = row;
        this.column = column;
        this.effort = effort;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EffortNode)) return false;
        EffortNode that = (EffortNode) o;
        return getRow() == that.getRow() && getColumn() == that.getColumn() && getEffort() == that.getEffort();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn(), getEffort());
    }

    @Override
    public String toString() {
        return "EffortNode{" +
                "row=" + row +
                ", column=" + column +
                ", effort=" + effort +
                '}';
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rowsLength = heights.length;
        int columnLength = heights[0].length;
        int[][] effortMatrix = new int[rowsLength][columnLength];

        PriorityQueue<EffortNode> priorityQueue = new PriorityQueue<>(Comparator.comparing(EffortNode::getEffort));
        IntStream.range(0, rowsLength).forEach(
                row -> Arrays.fill(effortMatrix[row], Integer.MAX_VALUE)
        );

        // Initialise effortMatrix with 0 effort for the starting point
        effortMatrix[0][0] = 0;
        priorityQueue.add(new EffortNode(0, 0, 0));

        // Directions to traverse
        int[] rowWiseDirection = {-1, 0, 1, 0};
        int[] columnWiseDiretion = {0, 1, 0, -1};

        while (!priorityQueue.isEmpty()) {
            EffortNode currentNode = priorityQueue.poll();
            int currentEffort = currentNode.getEffort();
            int currentRow = currentNode.getRow();
            int currentColumn = currentNode.getColumn();

            // End of the matrix
            if (currentRow == rowsLength - 1 && currentColumn == columnLength - 1)
                return currentEffort;

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + rowWiseDirection[i];
                int newColumn = currentColumn + columnWiseDiretion[i];

                if (newRow >= 0 && newColumn >= 0 && newRow < rowsLength && newColumn < columnLength) {
                    int newEffort = Math.max(Math.abs(heights[currentRow][currentColumn] - heights[newRow][newColumn]), currentEffort);

                    if (newEffort < effortMatrix[newRow][newColumn]) {
                        effortMatrix[newRow][newColumn] = newEffort;
                        priorityQueue.add(new EffortNode(newRow, newColumn, newEffort));
                    }
                }
            }
        }

        // If the destination is unreachable
        return 0;
    }
}