class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Long> countMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        return countMap.entrySet()
                .stream()
                .map(m -> m.getValue())
                .anyMatch(countVal -> countVal > 1);
    }
}
