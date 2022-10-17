class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        // Iterating both the arrays respectively
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], map.getOrDefault(items1[i][0], 0) + items1[i][1]);
        }

        for (int i = 0; i < items2.length; i++) {
            map.put(items2[i][0], map.getOrDefault(items2[i][0], 0) + items2[i][1]);
        }

        // Iterating the map and adding in the list
        map.entrySet().stream()
                .forEach(
                        (entry) ->
                        {
                            List<Integer> list = new ArrayList<>();
                            list.add(entry.getKey());
                            list.add(entry.getValue());
                            ret.add(list);
                        }
                );

        return ret;  
    }
}