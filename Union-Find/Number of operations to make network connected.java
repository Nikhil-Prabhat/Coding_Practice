class Solution {
    
    public int extra = 0;
    public int required = 0;

    public int makeConnected(int n, int[][] connections) {
          boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

       Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] val1, int[] val2) {
                return val1[0] - val2[0];
            }
        }.thenComparing(new Comparator<int[]>() {
            @Override
            public int compare(int[] val1, int[] val2) {
                return val1[1] - val2[1];
            }
        }));

        Arrays.stream(connections).forEach(
                conn -> {
                    if (!(visited[conn[0]] && visited[conn[1]])) {
                        visited[conn[0]] = true;
                        visited[conn[1]] = true;
                    } else {
                        extra++;
                    }
                }
        );

        for (boolean bool : visited) {
            if (!bool)
                required++;
        }

       

        return extra >= required ? required : -1;
    }
}

-- Solved

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1)
            return -1;
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] val1, int[] val2) {
                return val1[0] - val2[0];
            }
        }.thenComparing(new Comparator<int[]>() {
            @Override
            public int compare(int[] val1, int[] val2) {
                return val1[1] - val2[1];
            }
        }));

        Arrays.stream(connections).forEach(
                conn -> {
                    if(findParent(parent ,conn[0]) != findParent(parent, conn[1]))
                        unionParent(parent, findParent(parent ,conn[0]), findParent(parent, conn[1]));
                }
        );

        int result = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i)
                result++;
        }

        return --result;

    }

    private void unionParent(int[] parent, int vertex1, int vertex2) {
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == vertex2)
                parent[i] = vertex1;
        }
    }

    private int findParent(int[] parent, int vertex) {
        return parent[vertex];
    }
}