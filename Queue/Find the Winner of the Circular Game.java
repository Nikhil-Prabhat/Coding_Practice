class Solution {
    public int findTheWinner(int n, int k) {
      Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            queue.add(i + 1);

        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();  
    }
}