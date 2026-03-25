record PathWithCost(Integer nodeVal, long cost) {};

class Solution {
    int MODULO = (int) (1e9 + 7);

    public int countPaths(int n, int[][] roads) {
        long[] distanceArr = new long[n];
        boolean[] visited = new boolean[n];
        int[] ways = new int[n];

        Map<Integer, List<PathWithCost>> roadsMap = initialiseGraph(roads);
        Arrays.fill(distanceArr, Long.MAX_VALUE);
        Arrays.fill(visited, Boolean.FALSE);

        distanceArr[0] = 0;
        ways[0] = 1;
        traverseGraph(roadsMap, visited, distanceArr, ways, n);
        return ways[n - 1];
    }

    private int getMinDistanceIndex(long[] distanceArr, boolean[] visited) {
        long minDistance = Long.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distanceArr.length; i++) {
            if (!visited[i] && distanceArr[i] <= minDistance) {
                minDistance = distanceArr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private Map<Integer, List<PathWithCost>> initialiseGraph(int[][] roads) {
        Map<Integer, List<PathWithCost>> graphMap = new HashMap<>();

        for (int[] road : roads) {
            graphMap.computeIfAbsent(road[0], source -> new ArrayList<>()).add(new PathWithCost(road[1], road[2]));
            graphMap.computeIfAbsent(road[1], source -> new ArrayList<>()).add(new PathWithCost(road[0], road[2]));
        }

        return graphMap;
    }

    private void traverseGraph(Map<Integer, List<PathWithCost>> roadsMap, boolean[] visited, long[] distanceArr,
            int[] ways, int noOfNode) {
        for (int i = 0; i < noOfNode - 1; i++) {
            int minDistanceVertex = getMinDistanceIndex(distanceArr, visited);
            List<PathWithCost> neighboursList = roadsMap.get(minDistanceVertex);
            visited[minDistanceVertex] = Boolean.TRUE;

            for (int j = 0; j < neighboursList.size(); j++) {
                var destinationNode = neighboursList.get(j).nodeVal();
                var costToDestination = neighboursList.get(j).cost();

                if (!visited[destinationNode] && distanceArr[minDistanceVertex] != Long.MAX_VALUE
                        && distanceArr[minDistanceVertex] + costToDestination < distanceArr[destinationNode]) {
                    distanceArr[destinationNode] = distanceArr[minDistanceVertex] + costToDestination;
                    ways[destinationNode] = ways[minDistanceVertex];
                } else if (distanceArr[minDistanceVertex] + costToDestination == distanceArr[destinationNode]) {
                    ways[destinationNode] = (ways[minDistanceVertex] + ways[destinationNode]) % MODULO;
                }
            }
        }
    }
}
