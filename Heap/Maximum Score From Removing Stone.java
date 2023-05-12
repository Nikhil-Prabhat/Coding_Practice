class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(a);
        maxHeap.add(b);
        maxHeap.add(c);
        int myScore = 0;

        while (maxHeap.size() > 1) {
            Integer firstMaximum = maxHeap.poll();
            Integer secondMaximum = maxHeap.poll();
            firstMaximum--;
            secondMaximum--;
            myScore++;

            if (firstMaximum > 0)
                maxHeap.add(firstMaximum);

            if (secondMaximum > 0)
                maxHeap.add(secondMaximum);
        }

        return myScore;
    }
}