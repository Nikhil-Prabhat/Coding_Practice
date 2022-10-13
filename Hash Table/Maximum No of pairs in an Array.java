class Solution {
    static int pair = 0;
    static int leftOver = 0;
    public int[] numberOfPairs(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (Integer num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        map.entrySet().stream().forEach(
                (entry) ->
                {
                    pair += entry.getValue() / 2;
                    leftOver += entry.getValue() % 2;
                }
        );

        // Setting the final result
        result[0] = pair;
        result[1] = leftOver;
        pair = 0;
        leftOver = 0;
        return result;
    }
}