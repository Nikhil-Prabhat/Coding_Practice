class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean[] safeNodes = new Boolean[graph.length];
        Arrays.fill(safeNodes, false);

        List<Integer> safeNodesList = new ArrayList<>();

        // Finding safe nodes
        IntStream.range(0, graph.length)
                .filter(index -> graph[index].length == 0)
                .forEach(
                        index -> {
                            safeNodes[index] = Boolean.TRUE;
                        }
                );

        for (int i = 0; i < graph.length; i++) {
            findSafeNodes(i, safeNodes, graph, new boolean[graph.length]);
        }

        for (int i = 0; i < safeNodes.length; i++) {
            if (safeNodes[i])
                safeNodesList.add(i);
        }

        return safeNodesList;
    }

    private boolean findSafeNodes(int node, Boolean[] safeNodes, int[][] graph, boolean[] visited) {
        // Base case
        if (safeNodes[node])
            return true;

        if (!safeNodes[node] && visited[node])
            return false;

        // First mark the node as visited
        visited[node] = true;

        // Iterate over the entire neighbours and if any node is unsafe, stop iterating from there only
        // Else iterate to the fullest
        for (int neighbourNode : graph[node]) {
            boolean isSafe = findSafeNodes(neighbourNode, safeNodes, graph, visited);

            if (isSafe)
                continue;

            if (!isSafe)
                return false;
        }

        safeNodes[node] = true;
        return true;
    }
}