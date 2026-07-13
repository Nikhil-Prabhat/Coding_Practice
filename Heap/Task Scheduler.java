class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] characterFrequency = new int[26];
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        IntStream.range(0, tasks.length)
                .forEach(index -> {
                    characterFrequency[tasks[index] - 'A']++;
                });

        IntStream.range(0, 26)
                .forEach(index -> {
                    if (characterFrequency[index] > 0) {
                        maxPriorityQueue.add(characterFrequency[index]);
                    }
                });

        int totalTimeRequired = 0;

        while (!maxPriorityQueue.isEmpty()) {
            var taskCycle = 0;
            var cycleLength = n + 1;
            List<Integer> tempTaskList = new ArrayList<>();

            while (cycleLength > 0 && !maxPriorityQueue.isEmpty()) {
                var currentTask = maxPriorityQueue.poll();
                if (currentTask > 1) {
                    tempTaskList.add(currentTask - 1);
                }

                taskCycle++;
                cycleLength--;
            }

            for (int taskEl : tempTaskList) {
                maxPriorityQueue.add(taskEl);
            }

            totalTimeRequired += maxPriorityQueue.isEmpty() ? taskCycle : n + 1;
        }

        return totalTimeRequired;
    }
}
