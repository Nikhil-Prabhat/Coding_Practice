class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, Boolean.FALSE);

        int completeConnectedComponents = 0;

        // Prepare the adjacency list for the graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());

        for (int[] row : edges) {
            int v1 = row[0];
            int v2 = row[1];

            // Since it is a bidirectional graph
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1);
        }

        completeConnectedComponents = BFSTraversal(adjacencyList, visited);

        return completeConnectedComponents;

    }

    private int BFSTraversal(List<List<Integer>> adjacencyList, boolean[] visited) {

        int completeConnectedComponents = 0;

        // Set to keep track of all the nodes in a connected components
        Set<Integer> connectedComponentSet = new HashSet<>();

        // Traverse all the connected components of a subgraph in a single go
        for (int i = 0; i < adjacencyList.size(); i++) {
            int startingVertex = i;
            int sizeOfConnectedComponents = 0;

            // If the vertex is not visited
            if (!visited[startingVertex]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(startingVertex);
                visited[startingVertex] = Boolean.TRUE;
                connectedComponentSet.clear();

                while (!queue.isEmpty()) {
                    // Get the head and iterate for all the connected vertices
                    int head = queue.poll();
                    connectedComponentSet.add(head);
                    int sizeOfHead = adjacencyList.get(head).size();
                    for (int j = 0; j < sizeOfHead && sizeOfHead > 0; j++) {
                        int connectedVertex = adjacencyList.get(head).get(j);
                        if (!visited[connectedVertex]) {
                            queue.add(connectedVertex);
                            visited[connectedVertex] = Boolean.TRUE;
                            sizeOfConnectedComponents++;
                        }
                    }
                }

                // Check for all the connected nodes for all the vertices in the component
                //int sizeOfParent = adjacencyList.get(startingVertex).size();
                boolean sameAsParentSize = Boolean.TRUE;
                List<Integer> connectedComponentList = connectedComponentSet.stream().collect(Collectors.toList());
                for(int j=0;j<connectedComponentList.size();j++)
                {
                    if(adjacencyList.get(connectedComponentList.get(j)).size() != sizeOfConnectedComponents)
                    {
                        sameAsParentSize = Boolean.FALSE;
                        break;
                    }
                }


                // If all vertices of a connected components have same size of vertices, then, it is a complete connected component
                if (sameAsParentSize)
                    completeConnectedComponents++;
            }
        }

        return completeConnectedComponents;
    }
}