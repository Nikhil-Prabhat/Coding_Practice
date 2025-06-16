class Solution {
    public int singleNumber(int[] nums) {
     Map<Integer, Long> countMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        return countMap.entrySet()
                .stream()
                .filter(map -> map.getValue() == 1)
                .map(map -> map.getKey().intValue())
                .findFirst()
                .get();   
    }
}
