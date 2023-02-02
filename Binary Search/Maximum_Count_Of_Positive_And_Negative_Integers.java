class Solution {
    public int maximumCount(int[] nums) {
       Map<Character, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(
                num -> {
                    if (num < 0)
                        map.put('-', map.getOrDefault('-', 0) + 1);
                    else if(num > 0)
                        map.put('+', map.getOrDefault('+', 0) + 1);
                }
        );


        return Math.max(map.getOrDefault('-',0),map.getOrDefault('+',0)); 
    }
}