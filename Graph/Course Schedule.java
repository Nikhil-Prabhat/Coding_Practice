class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyMatrix = new ArrayList[numCourses];
        int[] inDegreeOfNodes = new int[numCourses];
        List<Integer> resultList = new ArrayList<>();

        for (int[] preRequisite : prerequisites) {
            int course = preRequisite[0];
            int preCourse = preRequisite[1];

            if (Objects.isNull(adjacencyMatrix[preCourse])) {
                adjacencyMatrix[preCourse] = new ArrayList<>();
            }

            adjacencyMatrix[preCourse].add(course);
            inDegreeOfNodes[course]++;
        }

        Queue<Integer> preRequisiteQueue = new LinkedList<>();
        IntStream.range(0, numCourses)
                .forEach(index -> {
                    if (inDegreeOfNodes[index] == 0) {
                        preRequisiteQueue.add(index);
                    }
                });

        while (!preRequisiteQueue.isEmpty()) {
            int currentCourse = preRequisiteQueue.poll();
            resultList.add(currentCourse);

            if (Objects.nonNull(adjacencyMatrix[currentCourse])) {
                for (int nextCourse : adjacencyMatrix[currentCourse]) {
                    inDegreeOfNodes[nextCourse]--;

                    if (inDegreeOfNodes[nextCourse] == 0) {
                        preRequisiteQueue.add(nextCourse);
                    }
                }
            }
        }

        return resultList.size() == numCourses;
    }
}

// Another tried solution

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses];

        // Initialise the course graph
        if(prerequisites.length == 0) {
            return true;
        }

        var startingPoint = prerequisites[0][1];
        isVisited[startingPoint] = true;

        for(int[] preRequisite : prerequisites) {
            if(isVisited[preRequisite[0]]) {
                return false;
            }

            isVisited[preRequisite[0]] = true;
        }

        return true;
    }
}
