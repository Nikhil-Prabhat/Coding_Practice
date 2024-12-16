public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] finalArray = new int[nums.length];
        PriorityQueue<ElementWithIndex> priorityQueue = new PriorityQueue<>(Comparator.comparing(ElementWithIndex::elementVal));

        IntStream.range(0, nums.length)
                .forEach(
                        currIndex -> {
                            priorityQueue.add(new ElementWithIndex(nums[currIndex], currIndex));
                        }
                );

        while (k-- > 0) {
            var smallestElementRecord = priorityQueue.poll();
            priorityQueue.add(new ElementWithIndex(smallestElementRecord.elementVal() * multiplier, smallestElementRecord.index()));
        }

        while (!priorityQueue.isEmpty()) {
            var currentElementRecord = priorityQueue.poll();
            finalArray[currentElementRecord.index()] = currentElementRecord.elementVal();
        }

        return finalArray;
    }
	
// Accepted Solution
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while (k-- > 0) {
            int currentMinIndex = findMinIndex(nums);
            nums[currentMinIndex] *= multiplier;
        }

        return nums;
    }

    private int findMinIndex(int[] arr) {
        int minIndex = -1;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
