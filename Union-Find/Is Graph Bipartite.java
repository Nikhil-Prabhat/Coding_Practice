class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colorArr = new int[graph.length];
        Arrays.fill(colorArr, -1);

        for (int index = 0; index < graph.length; index++) {
            if (colorArr[index] == -1) {
                Queue<Integer> colorQueue = new LinkedList<>();
                colorArr[index] = 0;
                colorQueue.add(index);

                while (!colorQueue.isEmpty()) {
                    Integer currentVertex = colorQueue.poll();
                    for (int neighbourVertex : graph[currentVertex]) {
                        if (colorArr[neighbourVertex] == -1) {
                            colorArr[neighbourVertex] = 1 - colorArr[currentVertex];
                            colorQueue.add(neighbourVertex);
                        } else if (colorArr[neighbourVertex] == colorArr[currentVertex]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
