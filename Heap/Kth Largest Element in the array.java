class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums)
            priorityQueue.add(num);

        int i=1;
        while (i++ != k)
            priorityQueue.poll();

        return priorityQueue.peek();  
    }
}