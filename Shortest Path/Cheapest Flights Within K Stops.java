record NodeWithDistance(int node, int distance) {
};

record StopsAndNodeWithDistance(int stop, NodeWithDistance nodeWithDistance){};

class Solution {
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<NodeWithDistance>> adjacencyMap = new HashMap<>();
        Arrays.stream(flights).forEach(
                arr -> {
                    List<NodeWithDistance> neighboursForSource = adjacencyMap.getOrDefault(arr[0], new ArrayList<>());
                    neighboursForSource.add(new NodeWithDistance(arr[1], arr[2]));
                    adjacencyMap.put(arr[0], neighboursForSource);
                }
        );

        int[] distArray = new int[n];
        Arrays.fill(distArray, Integer.MAX_VALUE);
        distArray[src] = 0;

        Queue<StopsAndNodeWithDistance> queue = new LinkedList<>();
        queue.add(new StopsAndNodeWithDistance(0, new NodeWithDistance(src, 0)));

        while (!queue.isEmpty()) {
            StopsAndNodeWithDistance stopsAndNodeWithDistance = queue.poll();
            int stop = stopsAndNodeWithDistance.stop();
            int node = stopsAndNodeWithDistance.nodeWithDistance().node();
            int cost = stopsAndNodeWithDistance.nodeWithDistance().distance();

            if (stop > k) {
                continue;
            }

            List<NodeWithDistance> neighbors = adjacencyMap.get(node);
            if (neighbors != null) {
                neighbors.forEach(nodeWithDistance -> {
                    int adjacentNode = nodeWithDistance.node();
                    int toDistance = nodeWithDistance.distance();

                    if ((cost + toDistance < distArray[adjacentNode]) && stop <= k) {
                        distArray[adjacentNode] = cost + toDistance;
                        queue.add(new StopsAndNodeWithDistance(stop + 1, new NodeWithDistance(adjacentNode, cost + toDistance)));
                    }
                });
            }

        }
        return distArray[dst] == Integer.MAX_VALUE ? -1 : distArray[dst];
    }
}
