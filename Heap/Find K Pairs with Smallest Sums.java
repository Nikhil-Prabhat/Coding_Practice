class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> smallestPairList = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return smallestPairList;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(firstIndexPair -> (nums1[firstIndexPair[0]] + nums2[firstIndexPair[1]])));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            priorityQueue.add(new int[]{i, 0});
        }

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            int[] indexPair = priorityQueue.poll();
            int firstIndex = indexPair[0];
            int secondIndex = indexPair[1];

            smallestPairList.add(Arrays.asList(nums1[firstIndex], nums2[secondIndex]));

            if (secondIndex + 1 < nums2.length) {
                priorityQueue.add(new int[]{firstIndex, secondIndex + 1});
            }
        }

        return smallestPairList;
    }
}
