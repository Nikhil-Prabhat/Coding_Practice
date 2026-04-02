class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxLHSLen = 0;

        Arrays.stream(nums)
                .forEach(num -> frequencyMap.merge(num, 1, Integer::sum));

        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(key + 1)) {
                maxLHSLen = Math.max(maxLHSLen, frequencyMap.get(key) + frequencyMap.get(key + 1));
            }
        }

        return maxLHSLen;
    }
}
