class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());

        IntStream.range(0, matrix.length)
                .forEach(
                        i -> IntStream.range(0, matrix[0].length)
                                .forEach(
                                        j -> priorityQueue.add(matrix[i][j])));

        while (k-- > 1) {
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }
}
