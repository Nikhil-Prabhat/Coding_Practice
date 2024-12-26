class Solution {
    int maximumProfit = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, List<Integer>> treeMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Boolean[] visitedArray = new Boolean[amount.length];
        int parentNode = 0;

        // Initialisation of graph
        Arrays.stream(edges)
                .forEach(
                        edge -> {
                            var firstNode = edge[0];
                            var secondNode = edge[1];

                            var firstNodeNeighbourList = treeMap.getOrDefault(firstNode, new ArrayList<>());
                            firstNodeNeighbourList.add(secondNode);
                            treeMap.put(firstNode, firstNodeNeighbourList);

                            var secondNodeNeighbourList = treeMap.getOrDefault(secondNode, new ArrayList<>());
                            secondNodeNeighbourList.add(firstNode);
                            treeMap.put(secondNode, secondNodeNeighbourList);
                        });

        Arrays.fill(visitedArray, false);
        parentMap.putIfAbsent(0, -1);
        distanceMap.putIfAbsent(0, 0);

        // Find parent and height of each node
        visitedArray[0] = true;
        dfsToFindParent(parentMap, distanceMap, treeMap, visitedArray, parentNode, distanceMap.get(parentNode) + 1);

        // Final tree once Bob traversal is complete
        computeTreeAfterBobTraversal(parentMap, distanceMap, bob, amount);

        // Find leaf nodes in the tree
        List<Integer> leafNodeList = findLeafNodesInTheTree(treeMap);

        // Compute maximum income of Alice
        return computeMaximumNetIncome(leafNodeList, parentMap, amount);
    }

    private void dfsToFindParent(Map<Integer, Integer> parentMap, Map<Integer, Integer> distanceMap,
            Map<Integer, List<Integer>> treeMap, Boolean[] visitedArray, Integer parentNode,
            Integer currentDistanceToTravel) {
        treeMap.get(parentNode)
                .stream()
                .filter(currentChild -> !visitedArray[currentChild])
                .forEach(
                        currentChild -> {
                            visitedArray[currentChild] = true;
                            parentMap.putIfAbsent(currentChild, parentNode);
                            distanceMap.putIfAbsent(currentChild, currentDistanceToTravel);
                            dfsToFindParent(parentMap, distanceMap, treeMap, visitedArray, currentChild,
                                    currentDistanceToTravel + 1);
                        });
    }

    private void computeTreeAfterBobTraversal(Map<Integer, Integer> parentMap, Map<Integer, Integer> distanceMap,
            int bob, int[] profitCost) {
        int bobCurrentDistance = 0;
        int currentBobNode = bob;

        while (currentBobNode != -1) {
            if (distanceMap.get(currentBobNode) > bobCurrentDistance) {
                profitCost[currentBobNode] = 0;
            } else if (distanceMap.get(currentBobNode) == bobCurrentDistance) {
                profitCost[currentBobNode] /= 2;
            }

            currentBobNode = parentMap.get(currentBobNode);
            bobCurrentDistance++;
        }
    }

    private List<Integer> findLeafNodesInTheTree(Map<Integer, List<Integer>> treeMap) {
        return treeMap.entrySet()
                .stream()
                .filter(map -> map.getValue().size() == 1 && map.getKey() != 0)
                .map(map -> map.getKey())
                .toList();
    }

    private int computeMaximumNetIncome(List<Integer> leafNodeList, Map<Integer, Integer> parentMap, int[] profitCost) {
        return leafNodeList.stream()
                .map(currentNode -> this.computeProfitForCurrentNode(parentMap, currentNode, profitCost))
                .reduce(maximumProfit, (maximumProfitOfLastLeaf,
                        profitForCurrentLeaf) -> maximumProfitOfLastLeaf < profitForCurrentLeaf ? profitForCurrentLeaf
                                : maximumProfitOfLastLeaf);
    }

    private int computeProfitForCurrentNode(Map<Integer, Integer> parentMap, int currentNode, int[] profitCost) {
        var profitForCurrentNode = 0;
        while (currentNode != -1) {
            profitForCurrentNode += profitCost[currentNode];
            currentNode = parentMap.get(currentNode);
        }

        return profitForCurrentNode;
    }
}
