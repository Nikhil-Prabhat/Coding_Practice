class Solution {

    int[] parent;
    int[] rank;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        initParentAndRank(n);
        Map<Integer, Set<Integer>> graph = buildGraph(n, dislikes);

        for (int node = 1; node <= n; node++) {
            Set<Integer> neighbours = graph.get(node);
            if (neighbours.size() == 0) {
                continue;
            }

            Integer firstNeighbour = neighbours.stream()
                    .findFirst()
                    .get();
            for (int neighbour : neighbours) {
                if (areNodesConnected(neighbour, node)) {
                    return false;
                }

                unionOfNodes(firstNeighbour, neighbour);
            }
        }
        return true;
    }

    private void initParentAndRank(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] dislikes) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }

        Arrays.stream(dislikes)
                .forEach(edge -> {
                    int source = edge[0];
                    int destination = edge[1];

                    graph.get(source).add(destination);
                    graph.get(destination).add(source);
                });

        return graph;
    }

    private void unionOfNodes(int firstNode, int secondNode) {
        int parentOfFirstNode = findParent(firstNode);
        int parentOfSecondNode = findParent(secondNode);

        if (parentOfFirstNode != parentOfSecondNode) {
            if (rank[parentOfFirstNode] > rank[parentOfSecondNode]) {
                rank[parentOfFirstNode]++;
                parent[parentOfSecondNode] = parentOfFirstNode;
            } else {
                parent[parentOfFirstNode] = parentOfSecondNode;
                rank[parentOfSecondNode]++;
            }
        }
    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        int actualParent = findParent(parent[node]);
        parent[node] = actualParent;
        return actualParent;
    }

    private boolean areNodesConnected(int firstNode, int secondNode) {
        return findParent(firstNode) == findParent(secondNode);
    }
}
