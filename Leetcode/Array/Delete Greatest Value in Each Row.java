class Solution {
    public int deleteGreatestValue(int[][] grid) {
        List<List<Integer>> gridList = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            gridList.add(new ArrayList<>());
            for (int j = 0; j < grid[0].length; j++) {
                gridList.get(i).add(grid[i][j]);
            }
        }

        int loopCount = grid[0].length;
        int answer = 0;

        while (loopCount-- > 0) {
            List<Integer> integerList = gridList.stream().map(listOfElements -> findMax(listOfElements)).collect(Collectors.toList());
            int maxOfEachRow = findMax(integerList);
            answer += maxOfEachRow;
        }

        return answer;
    }

    public int findMax(List<Integer> list) {
        int max = list.stream().mapToInt(a -> a).max().getAsInt();
        list.remove(Integer.valueOf(max));
        return max;
    }
}