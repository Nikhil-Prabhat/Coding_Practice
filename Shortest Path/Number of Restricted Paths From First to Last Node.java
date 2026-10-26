class Solution {

    int MODULO = 1000000007;
    int[] memoizedTable;

    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, List<int[]>> edgeMap = new HashMap<>();
        memoizedTable = new int[n + 1];
        Arrays.fill(memoizedTable, -1);

        boolean[] visited = new boolean[n + 1];
        Arrays.stream(edges).forEach(edge -> {
            edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[] { edge[2], edge[1] });
            edgeMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[] { edge[2], edge[0] });
        });

        int[] shortestPathArray = createShortestPathArray(n, edgeMap, n);
        visited[1] = true;
        return getRestrictedPathForANode(n, edgeMap, 1, visited, shortestPathArray);
    }

    private int getRestrictedPathForANode(int vertices, Map<Integer, List<int[]>> edgeMap, int currentVertex,
            boolean[] visited, int[] shortestPathArray) {
        if (currentVertex == vertices) {
            return 1;
        }

        if (memoizedTable[currentVertex] != -1) {
            return memoizedTable[currentVertex];
        }

        var restrictedPathCount = 0;
        for (int[] currentNeighbourWithDistance : edgeMap.get(currentVertex)) {
            var currentNeighbour = currentNeighbourWithDistance[1];
            if (!visited[currentNeighbour]
                    && (shortestPathArray[currentVertex] > shortestPathArray[currentNeighbour])) {
                visited[currentNeighbour] = true;
                restrictedPathCount += (getRestrictedPathForANode(vertices, edgeMap, currentNeighbour, visited,
                        shortestPathArray) % MODULO);
                visited[currentNeighbour] = false;
            }
        }

        return memoizedTable[currentVertex] = (int) restrictedPathCount % MODULO;
    }

    private int[] createShortestPathArray(int vertices, Map<Integer, List<int[]>> edgeMap, int source) {
        int[] distanceArr = new int[vertices + 1];
        Arrays.fill(distanceArr, Integer.MAX_VALUE);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (firstNode, secondNode) -> firstNode[0] - secondNode[0]);
        distanceArr[source] = 0;
        priorityQueue.add(new int[] { 0, source });

        while (!priorityQueue.isEmpty()) {
            var currentNode = priorityQueue.poll();
            var currentDistance = currentNode[0];
            var currentVertex = currentNode[1];

            if (currentDistance > distanceArr[currentVertex]) {
                continue;
            }

            for (int[] currentNeighbour : edgeMap.get(currentVertex)) {
                var nextDistance = currentNeighbour[0];
                var nextNode = currentNeighbour[1];

                if (distanceArr[currentVertex] + nextDistance < distanceArr[nextNode]) {
                    distanceArr[nextNode] = distanceArr[currentVertex] + nextDistance;
                    priorityQueue.add(new int[] { distanceArr[nextNode], nextNode });
                }
            }
        }

        return distanceArr;
    }
}
