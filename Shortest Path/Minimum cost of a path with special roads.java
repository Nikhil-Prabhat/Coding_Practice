class Solution {
    record NodeCoordinates(Integer XCoordinate, Integer YCoordinate) {
    };

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Set<NodeCoordinates> visitedNodes = new HashSet<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        priorityQueue.add(new int[] { start[0], start[1], 0 });

        while (!priorityQueue.isEmpty()) {
            int[] currentNodeInfo = priorityQueue.poll();
            int xCoordinate = currentNodeInfo[0], yCoordinate = currentNodeInfo[1], cost = currentNodeInfo[2];
            NodeCoordinates currentNode = new NodeCoordinates(xCoordinate, yCoordinate);

            if (visitedNodes.contains(currentNode)) {
                continue;
            }

            if (xCoordinate == target[0] && yCoordinate == target[1]) {
                return cost;
            }

            visitedNodes.add(currentNode);
            priorityQueue.add(new int[] { target[0], target[1],
                    cost + Math.abs(target[0] - xCoordinate) + Math.abs(target[1] - yCoordinate) });

            Arrays.stream(specialRoads)
                    .forEach(specialRoad -> {
                        if (!visitedNodes.contains(new NodeCoordinates(specialRoad[2], specialRoad[3]))) {
                            priorityQueue.add(
                                    new int[] { specialRoad[2], specialRoad[3], Math.abs(specialRoad[0] - xCoordinate)
                                            + Math.abs(specialRoad[1] - yCoordinate) + cost + specialRoad[4] });
                        }
                    });
        }

        return -1;
    }
}
