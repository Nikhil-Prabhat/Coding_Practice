class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegreeArr = new int[n];
        List<Integer> rootNodeList = new ArrayList<>();

        Arrays.fill(indegreeArr, 0);
        Arrays.stream(edges)
                .forEach(edge -> {
                    adjacencyList.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
                    adjacencyList.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
                    indegreeArr[edge[0]]++;
                    indegreeArr[edge[1]]++;
                });

        IntStream.range(0, n)
                .forEach(index -> {
                    if (indegreeArr[index] == 1) {
                        queue.add(index);
                    }
                });

        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();
            rootNodeList.clear();

            IntStream.range(0, currentQueueSize)
                    .forEach(index -> {
                        int currentNode = queue.poll();
                        rootNodeList.add(currentNode);

                        for (int neighbourNode : adjacencyList.get(currentNode)) {
                            indegreeArr[neighbourNode]--;

                            if (indegreeArr[neighbourNode] == 1) {
                                queue.add(neighbourNode);
                            }
                        }
                    });
        }

        if (n == 1) {
            rootNodeList.add(0);
        }

        return rootNodeList;
    }
}
