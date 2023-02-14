class Solution {

    long sum = 0l;

    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.stream(gifts).forEach(
                gift -> priorityQueue.add(gift)
        );

        for (int i = 0; i < k; i++) {
            Integer maxGift = priorityQueue.poll();
            int remainingGift = (int) Math.floor(Math.sqrt(maxGift));
            priorityQueue.add(remainingGift);
        }

        sum = 0l;
        priorityQueue.stream().forEach(
                val -> sum += val
        );

        return sum;

    }
}