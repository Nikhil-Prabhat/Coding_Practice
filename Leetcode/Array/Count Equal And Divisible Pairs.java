class Solution {
    static int count;

    public int countPairs(int[] nums, int k) {
      
      Map<Integer, List<Integer>> map = new HashMap<>();
      count = 0;

      for (int i = 0; i < nums.length; i++) {
            List<Integer> integerList = map.getOrDefault(nums[i], new ArrayList<>(i));
            integerList.add(i);
            map.put(nums[i], integerList);
        }

        map.entrySet().stream().forEach(
                m -> {
                    if (m.getValue().size() > 1) {
                        List<Integer> numList = m.getValue();
                        for (int i = 0; i < numList.size(); i++) {
                            for (int j = i + 1; j < numList.size(); j++) {
                                if ((numList.get(i) * numList.get(j)) % k == 0)
                                    count++;
                            }
                        }
                    }
                }
        );
        
        return count;  
    }
}