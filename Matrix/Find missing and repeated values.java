class Solution {
    Map<Integer, Boolean> map = new HashMap<>();
    
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] result = new int[2];

        IntStream.range(1, (n * n) + 1)
                .forEach(
                        index -> {
                            map.put(index, false);
                        }
                );

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(grid[i][j]) && map.get(grid[i][j])) {
                    result[0] = grid[i][j];
                    continue;
                }
                map.put(grid[i][j], true);
            }
        }

        Integer leftKey = map.entrySet()
                .stream()
                .filter(mapEntry -> !mapEntry.getValue())
                .findFirst()
                .get()
                .getKey();

        result[1] = leftKey;

        return result;
    }
}