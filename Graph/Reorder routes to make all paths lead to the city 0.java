class Solution {

     int count = 0;
     
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> connectionsMap = new HashMap<>();
        Map<Integer, List<Integer>> neighboursMap = new HashMap<>();

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int[] connection : connections) {
            int source = connection[0];
            int destination = connection[1];

            // Add bidirectional graph for neighbours map and unidirectional graph for connections map
            // Bidirectional Map
            List<Integer> sourceNeighbours = neighboursMap.getOrDefault(source, new ArrayList<>());
            sourceNeighbours.add(destination);
            neighboursMap.put(source, sourceNeighbours);

            List<Integer> destinationNeighbours = neighboursMap.getOrDefault(destination, new ArrayList<>());
            destinationNeighbours.add(source);
            neighboursMap.put(destination, destinationNeighbours);

            // Unidirectional Map
            List<Integer> sourceConnections = connectionsMap.getOrDefault(source, new ArrayList<>());
            sourceConnections.add(destination);
            connectionsMap.put(source, sourceConnections);
        }

        visited[0] = true;

        findRoute(0, connectionsMap, neighboursMap, visited);
        return count;
    }

    private void findRoute(int city, Map<Integer, List<Integer>> connectionsMap, Map<Integer, List<Integer>> neighboursMap, boolean[] visited) {
        for (int neighbour : neighboursMap.get(city)) {
            if (visited[neighbour])
                continue;

            if (Objects.isNull(connectionsMap.get(neighbour)) || !connectionsMap.get(neighbour).contains(city))
                count++;


            visited[neighbour] = true;
            findRoute(neighbour, connectionsMap, neighboursMap, visited);
        }
    }

}