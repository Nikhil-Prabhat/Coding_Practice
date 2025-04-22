record NodeWithDistance(int node, int distance) {
};

class Solution {
    Map<Integer, List<NodeWithDistance>> adjacencyMap = new HashMap<>();
    Integer scoreOfPath = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        boolean[] visited = new boolean[n + 1];

        var sortedRoads = Arrays.stream(roads)
                .sorted(Comparator.comparingInt(arr -> arr[2]))
                .toList();

        sortedRoads.forEach(
                tuple -> {
                    int source = tuple[0];
                    int destination = tuple[1];
                    int distance = tuple[2];

                    List<NodeWithDistance> sourceNeighbourList = adjacencyMap.getOrDefault(source, new ArrayList<>());
                    sourceNeighbourList.add(new NodeWithDistance(destination, distance));
                    adjacencyMap.put(source, sourceNeighbourList);

                    List<NodeWithDistance> destinationNeighbourList = adjacencyMap.getOrDefault(destination,
                            new ArrayList<>());
                    destinationNeighbourList.add(new NodeWithDistance(source, distance));
                    adjacencyMap.put(destination, destinationNeighbourList);
                });

        visited[1] = true;
        iterateByDFS(1, visited);
        return scoreOfPath;
    }

    private void iterateByDFS(int sourceNode, boolean[] visited) {
        for (NodeWithDistance neighbour : adjacencyMap.get(sourceNode)) {
            if (!visited[neighbour.node()]) {
                if (neighbour.distance() < scoreOfPath)
                    scoreOfPath = neighbour.distance();

                visited[neighbour.node()] = true;
                iterateByDFS(neighbour.node(), visited);
            }
        }
    }
}
