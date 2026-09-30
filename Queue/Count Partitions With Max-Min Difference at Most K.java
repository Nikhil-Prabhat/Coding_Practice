class Solution {

    int MODULO = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int len = nums.length;
        long[] dp = new long[len + 1];
        long[] prefix = new long[len + 2];

        dp[0] = 1;
        prefix[1] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < len; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // Shrink window if max - min > k
            while ((long) nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            dp[right + 1] = (prefix[right + 1] - prefix[left] + MODULO) % MODULO;
            prefix[right + 2] = (prefix[right + 1] + dp[right + 1]) % MODULO;
        }

        return (int) dp[len];
    }
}
