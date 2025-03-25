class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();

        Arrays.stream(edges).forEach(
                edge -> {
                    List<Integer> toEdgeNeighbours = edgesMap.getOrDefault(edge[0], new ArrayList<>());
                    toEdgeNeighbours.add(edge[1]);
                    edgesMap.put(edge[0], toEdgeNeighbours);

                    List<Integer> fromEdgeNeighbours = edgesMap.getOrDefault(edge[1], new ArrayList<>());
                    fromEdgeNeighbours.add(edge[0]);
                    edgesMap.put(edge[1], fromEdgeNeighbours);
                }
        );

        int startVertex = 0;
        return iterateTreeAndComputeTime(0, -1, edgesMap, hasApple);
    }

    private int iterateTreeAndComputeTime(int currentVertex, int parent, Map<Integer, List<Integer>> edgesMap, List<Boolean> hasApple) {
        int minTime = 0;

        if(Objects.nonNull(edgesMap.get(currentVertex))) {
            for (int childVertex : edgesMap.get(currentVertex)) {
                if (childVertex == parent) {
                    continue;
                }

                int calculatedTime = iterateTreeAndComputeTime(childVertex, currentVertex, edgesMap, hasApple);
                if (calculatedTime > 0 || hasApple.get(childVertex)) {
                    minTime += (2 + calculatedTime);
                }
            }
        }

        return minTime;
    }
}
