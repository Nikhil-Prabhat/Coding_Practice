class Solution {
    public long continuousSubarrays(int[] nums) {
        Integer shrinkIndex = 0;
        long finalAnswer = 0;
        Deque<Integer> minimumQueue = new LinkedList<>();
        Deque<Integer> maximumQueue = new LinkedList<>();

        for (int index = 0; index < nums.length; index++) {
            while (!minimumQueue.isEmpty() && nums[minimumQueue.peekLast()] >= nums[index]) {
                minimumQueue.pollLast();
            }

            while (!maximumQueue.isEmpty() && nums[maximumQueue.peekLast()] <= nums[index]) {
                maximumQueue.pollLast();
            }

            minimumQueue.addLast(index);
            maximumQueue.addLast(index);

            // Shrink the window if the condition doesn't hold
            while (nums[maximumQueue.peekFirst()] - nums[minimumQueue.peekFirst()] > 2) {
                shrinkIndex++;

                // Remove index which is out of window now
                if (minimumQueue.peekFirst() < shrinkIndex) {
                    minimumQueue.pollFirst();
                }

                if (maximumQueue.peekFirst() < shrinkIndex) {
                    maximumQueue.pollFirst();
                }
            }

            finalAnswer += (index - shrinkIndex + 1);
        }
        return finalAnswer;
    }
}
