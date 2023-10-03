class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] connectionsCountForEachVertex = new int[n];
        boolean[][] graph = new boolean[n][n];

        Arrays.stream(roads).forEach(
                arr -> {
                    connectionsCountForEachVertex[arr[0]]++;
                    connectionsCountForEachVertex[arr[1]]++;
                    graph[arr[0]][arr[1]] = true;
                    graph[arr[1]][arr[0]] = true;
                }
        );

        int maxNetwork = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxNetwork = Math.max(maxNetwork, connectionsCountForEachVertex[i] + connectionsCountForEachVertex[j]
                        - ((graph[i][j]) ? 1 : 0));
            }
        }

        return maxNetwork;
    }
}