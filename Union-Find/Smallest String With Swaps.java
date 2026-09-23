class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        initGraph(pairs);

        Boolean[] visited = new Boolean[s.length()];
        Arrays.fill(visited, false);
        char[] resultArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                continue;
            }

            // Get all indices connected to current Index
            List<Integer> connectedIndices = new ArrayList<>();
            getAllConnectedIndices(i, visited, connectedIndices);

            List<Character> connectedCharacters = connectedIndices.stream()
                    .map(index -> s.charAt(index))
                    .sorted()
                    .toList();
            Collections.sort(connectedIndices);

            for (int j = 0; j < connectedIndices.size(); j++) {
                resultArr[connectedIndices.get(j)] = connectedCharacters.get(j);
            }
        }

        return new String(resultArr);
    }

    private void initGraph(List<List<Integer>> pairs) {
        for (List<Integer> pair : pairs) {
            var firstIndex = pair.getFirst();
            var secondIndex = pair.getLast();

            graph.computeIfAbsent(firstIndex, key -> new ArrayList<>()).add(secondIndex);
            graph.computeIfAbsent(secondIndex, key -> new ArrayList<>()).add(firstIndex);
        }
    }

    private void getAllConnectedIndices(int currentIndex, Boolean[] visited, List<Integer> indices) {
        visited[currentIndex] = true;
        indices.add(currentIndex);

        for (int neighbour : graph.getOrDefault(currentIndex, new ArrayList<>())) {
            if (!visited[neighbour]) {
                getAllConnectedIndices(neighbour, visited, indices);
            }
        }
    }
}
