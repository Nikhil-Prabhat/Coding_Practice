class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if(ops.length == 0) {
            return m * n;
        }

        for (int[] op : ops) {
            minHeap.add(op[0]);
        }

        int firstRange = minHeap.poll();
        minHeap.clear();

        for (int[] op : ops) {
            minHeap.add(op[1]);
        }

        int secondRange = minHeap.poll();
        return firstRange * secondRange;
    }
}
