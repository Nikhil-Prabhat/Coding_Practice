record NodeWithCost(Integer nodeVal, Integer cost) {
};

class Solution {

    Map<Integer, List<NodeWithCost>> nodesMap = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        prepareNodesMap(times);
        int[] distanceArr = new int[n];
        Boolean[] visited = new Boolean[n];

        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        Arrays.fill(visited, Boolean.FALSE);

        distanceArr[k - 1] = 0;

        // Iterate over all the vertices and find the shortest path
        for (int i = 0; i < n - 1; i++) {
            var minDistanceVertex = findMinimumDistanceVertex(distanceArr, visited);
            visited[minDistanceVertex] = Boolean.TRUE;
            List<NodeWithCost> neighboursList = nodesMap.get(minDistanceVertex);

            if (Objects.nonNull(neighboursList)) {
                for (int j = 0; j < neighboursList.size(); j++) {
                    var currentVertex = neighboursList.get(j).nodeVal();
                    if (!visited[currentVertex] && distanceArr[minDistanceVertex] != Integer.MAX_VALUE
                            && distanceArr[minDistanceVertex]
                                    + neighboursList.get(j).cost() <= distanceArr[currentVertex]) {
                        distanceArr[currentVertex] = distanceArr[minDistanceVertex] + neighboursList.get(j).cost();
                    }
                }
            }
        }

        if (n == k && Objects.nonNull(nodesMap.get(k - 1))) {
            return Arrays.stream(distanceArr)
                    .sorted()
                    .skip(1)
                    .findFirst()
                    .getAsInt();
        } else if (distanceArr[n - 1] == 0 && !Arrays.stream(visited).allMatch(matchEl -> matchEl == Boolean.TRUE)) {
            return -1;
        } else {
            //return (distanceArr[n - 1] != Integer.MAX_VALUE) ? distanceArr[n - 1] : -1;
            return (Arrays.stream(distanceArr).allMatch(distanceEl -> distanceEl != Integer.MAX_VALUE))
                    ? distanceArr[n - 1]
                    : -1;
        }
    }

    private void prepareNodesMap(int[][] times) {
        Arrays.stream(times).forEach(
                timeArr -> {
                    List<NodeWithCost> neighboursList = nodesMap.getOrDefault(timeArr[0] - 1, new ArrayList<>());
                    neighboursList.add(new NodeWithCost(timeArr[1] - 1, timeArr[2]));
                    nodesMap.put(timeArr[0] - 1, neighboursList);
                });
    }

    private int findMinimumDistanceVertex(int[] distanceArr, Boolean[] visited) {
        int minimumVal = Integer.MAX_VALUE, minVertex = -1;

        for (int i = 0; i < distanceArr.length; i++) {
            if (!visited[i] && distanceArr[i] <= minimumVal) {
                minimumVal = distanceArr[i];
                minVertex = i;
            }
        }

        return minVertex;
    }
}

// Accepted Solution

class Solution {
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int n, path;
        Pair(int n, int p) {
            this.n = n;
            this.path = p;
        }
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            graph[u].add(new Edge(u, v, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k - 1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.n;
            int d = curr.path;

            if (d > dist[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        int res = 0;
        for (int t : dist) {
            if (t == Integer.MAX_VALUE) return -1;
            res = Math.max(res, t);
        }

        return res;
    }
}

//
