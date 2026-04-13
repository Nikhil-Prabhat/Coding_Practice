class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] indegreeOfCourse = new int[numCourses];

        IntStream.range(0, numCourses)
                .forEach(index -> adjacencyList.add(new ArrayList<>()));

        Arrays.stream(prerequisites)
                .forEach(prerequisite -> {
                    var independentCourse = prerequisite[1];
                    var dependentCourse = prerequisite[0];

                    adjacencyList.get(independentCourse).add(dependentCourse);
                    indegreeOfCourse[dependentCourse]++;
                });

        Queue<Integer> courseQueue = new LinkedList<>();
        IntStream.range(0, numCourses).forEach(index -> {
            if (indegreeOfCourse[index] == 0) {
                courseQueue.add(index);
            }
        });

        int[] orderedCourses = new int[numCourses];
        int courseIndex = 0;

        while (!courseQueue.isEmpty()) {
            Integer currentCourse = courseQueue.poll();
            orderedCourses[courseIndex++] = currentCourse;

            for (int neighbour : adjacencyList.get(currentCourse)) {
                indegreeOfCourse[neighbour]--;

                if (indegreeOfCourse[neighbour] == 0) {
                    courseQueue.add(neighbour);
                }
            }
        }

        if (courseIndex == numCourses) {
            return orderedCourses;
        }

        return new int[0];
    }
}
