class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((firstNum, secondNum) -> {
            var firstDifference = Math.abs(x - firstNum);
            var secondDifference = Math.abs(x - secondNum);

            if (firstDifference < secondDifference) {
                return -1;
            } else if ((firstDifference == secondDifference) && (firstNum < secondNum)) {
                return -1;
            } else if ((firstDifference == secondDifference) && (firstNum > secondNum)) {
                return 1;
            } else if (firstDifference == secondDifference) {
                return 0;
            } else {
                return 1;
            }
        });

        Arrays.stream(arr).forEach(priorityQueue::add);

        return IntStream.range(0, k)
                .mapToObj(index -> priorityQueue.poll())
                .sorted()
                .collect(Collectors.toList());
    }
}
