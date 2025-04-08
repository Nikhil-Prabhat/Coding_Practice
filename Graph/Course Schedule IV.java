class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Boolean[] visited = new Boolean[numCourses];
        Arrays.fill(visited, false);

        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        Arrays.stream(prerequisites).forEach(
                pair -> {
                    List<Integer> neighbourList = graphMap.getOrDefault(pair[0], new ArrayList<>());
                    neighbourList.add(pair[1]);
                    graphMap.put(pair[0], neighbourList);
                });

        return Arrays.stream(queries).map(
                query -> {
                    Arrays.fill(visited, false);
                    boolean isPrerequisite = iterateGraphByDFS(graphMap, visited, query[0], query[1]);
                    return isPrerequisite;
                }).collect(Collectors.toList());
    }

    private boolean iterateGraphByDFS(Map<Integer, List<Integer>> graphMap, Boolean[] visited, int currentVertex,
            int destinationVertex) {
        if (currentVertex == destinationVertex) {
            return true;
        }

        visited[currentVertex] = true;
        boolean isFound = false;
        var neighbourList = graphMap.get(currentVertex);
        if (Objects.nonNull(neighbourList)) {
            for (Integer neighbour : graphMap.get(currentVertex)) {
                if (!visited[neighbour]) {
                    isFound = iterateGraphByDFS(graphMap, visited, neighbour, destinationVertex);
                }

                if (isFound) {
                    return true;
                }
            }
        }

        return false;
    }
}
