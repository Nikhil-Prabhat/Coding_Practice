class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int res = 1;

        int l = 0;

        // find the longest subarray for every right pointer by shrinking left pointer
        for (int r = 0; r < nums.length; ++r) {

            // update maxDeque with new right pointer
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[r]);

            // update minDeque with new right pointer
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[r]);

            // shrink left pointer if exceed limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
                ++l;  // shrink it!
            }

            // update res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    /*public int longestSubarray(int[] nums, int limit) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                minHeap.add(nums[j]);
                maxHeap.add(nums[j]);
            }

            int maxElement = maxHeap.peek();
            int minElement = minHeap.peek();

            if(Math.abs(maxElement-minElement) <= limit)
                return (nums.length-i);

            maxHeap.clear();
            minHeap.clear();
        }

        return -1;
    }*/
}