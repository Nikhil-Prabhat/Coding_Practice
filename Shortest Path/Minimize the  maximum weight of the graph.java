record MinMaxPair(int min, int max){};

class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        MinMaxPair minMaxRecord = findMinAndMax(edges);
        return searchMinimumEdge(minMaxRecord.min(), minMaxRecord.max(), n, edges);
    }

    public MinMaxPair findMinAndMax(int[][] edges) {
        int minimumWeight = Arrays.stream(edges)
                .map(edgeMappingFunction)
                .min(Comparator.naturalOrder())
                .get();

        int maximumWeight = Arrays.stream(edges)
                .map(edgeMappingFunction)
                .max(Comparator.naturalOrder())
                .get();

        return new MinMaxPair(minimumWeight, maximumWeight);
    }

    private int searchMinimumEdge(int startIndex, int endIndex, int arrLength, int[][] edges) {
        int answer = -1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (isPossible(arrLength, edges, mid)) {
                answer = mid;
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return answer;
    }

    private boolean isPossible(int n, int[][] edges, int maxWeight) {
        List<List<Integer>> reverseGraph = new ArrayList<>();
        IntStream.range(0, n).forEach(index -> reverseGraph.add(new ArrayList<>()));

        Arrays.stream(edges)
                .filter(edge -> edge[2] <= maxWeight)
                .forEach(
                        edge -> reverseGraph.get(edge[1]).add(edge[0])
                );

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for(int child : reverseGraph.get(current)) {
                if(!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                    count++;
                }
            }
        }
        
        return count == n;
    }

    private Function<int[], Integer> edgeMappingFunction = edge -> edge[2];
}
