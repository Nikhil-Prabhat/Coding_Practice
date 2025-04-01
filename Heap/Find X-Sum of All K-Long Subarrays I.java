class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int numsLen = nums.length;
        int[] resultArray = new int[numsLen - k + 1];
        int resultArrLen = resultArray.length;

        IntStream.range(0, resultArrLen)
                .forEach(
                        index -> {
                            int[] subArr = Arrays.copyOfRange(nums, index, index + k);

                            Map<Integer, Long> countMap = Arrays.stream(subArr)
                                    .boxed()
                                    .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
                            var sumOfSubArr = 0;
                            var counter = 0;

                            Comparator<Map.Entry<Integer, Long>> comparatorByValue = (entry1, entry2) -> (int) (entry2.getValue() - entry1.getValue());
                            Comparator<Map.Entry<Integer, Long>> comparatorByValueAndKey = comparatorByValue.thenComparing((entry1, entry2) -> (entry2.getKey() - entry1.getKey()));

                            PriorityQueue<Map.Entry<Integer, Long>> heap = new PriorityQueue<>(comparatorByValueAndKey);
                            countMap.entrySet().stream().forEach(
                                    entrySet -> heap.add(entrySet)
                            );

                            while ((counter++ < x) && !heap.isEmpty()) {
                                Map.Entry<Integer, Long> entry = heap.poll();
                                sumOfSubArr += (entry.getKey() * entry.getValue());
                            }

                            resultArray[index] = sumOfSubArr;
                        }
                );

        return resultArray;

    }
}
