class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> sortedList = Arrays.stream(nums)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        if(sortedList.size() >= 3) {
            return sortedList.stream()
                    .skip(2)
                    .findFirst()
                    .get();
        } 
        
        return sortedList.stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}
