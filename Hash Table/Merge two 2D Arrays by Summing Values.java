class Solution {

    int index = 0;

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
        Map<Integer, Integer> map3 = new TreeMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i][0], map1.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
        }

        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i][0], map2.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        map1.entrySet().stream().forEach(
                (map) -> {
                    if (!map3.containsKey(map.getKey()))
                        map3.put(map.getKey(), map3.getOrDefault(map.getKey(), 0) + map.getValue() + map2.getOrDefault(map.getKey(), 0));
                }
        );

        map2.entrySet().stream().forEach(
                (map) -> {
                    if (!map3.containsKey(map.getKey()))
                        map3.put(map.getKey(), map3.getOrDefault(map.getKey(), 0) + map.getValue() + map1.getOrDefault(map.getKey(), 0));
                }
        );

        int[][] resultArray = new int[map3.size()][2];

        map3.entrySet().stream().forEach(
                map -> {
                    resultArray[index][0] = map.getKey();
                    resultArray[index][1] = map.getValue();
                    ++index;
                }
        );

        return resultArray;
    }
}