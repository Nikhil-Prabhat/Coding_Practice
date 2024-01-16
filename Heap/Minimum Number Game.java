class Solution {
    public int[] numberGame(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            priorityQueue.add(num);
        }

        while (!priorityQueue.isEmpty()) {
            int aliceElement = priorityQueue.poll();
            int bobElement = !priorityQueue.isEmpty() ? priorityQueue.poll() : -1;

            if (bobElement != -1) {
                resultList.add(bobElement);
            }

            resultList.add(aliceElement);
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}