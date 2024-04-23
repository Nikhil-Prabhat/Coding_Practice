class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> topFrequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        int[] resultArray = topFrequencyMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(map -> map.getKey())
                .mapToInt(Integer::intValue)
                .limit(k)
                .toArray();

        return resultArray;
    }
}