class CustomIndex {

    int i;
    int j;

    public CustomIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomIndex)) return false;
        CustomIndex that = (CustomIndex) o;
        return getI() == that.getI() && getJ() == that.getJ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getI(), getJ());
    }

    @Override
    public String toString() {
        return "CustomIndex{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

class Solution {

    Queue<CustomIndex> queue = new LinkedList<>();
    Boolean[][] visited;
    List<Integer> intermediateList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();


    public int[][] findFarmland(int[][] land) {

        int[][] result = new int[1][1];
        int noOfRows = land.length;
        int noOfColumns = land[0].length;

        // Visited Array Initialisation
        visited = new Boolean[noOfRows][noOfColumns];
        for (int i = 0; i < noOfRows; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                if (land[i][j] == 0)
                    continue;

                if (land[i][j] == 1 && !visited[i][j]) {
                    intermediateList.clear();
                    queue.add(new CustomIndex(i, j));
                    iterateLandArray(land, noOfRows, noOfColumns);
                    resultList.add(new ArrayList<>());
                    resultList.get(resultList.size() - 1).addAll(intermediateList);
                }
            }
        }

        int[][] finalResult = new int[resultList.size()][4];

        for (int i = 0; i < resultList.size(); i++) {
            finalResult[i][0] = resultList.get(i).get(0);
            finalResult[i][1] = resultList.get(i).get(1);
            finalResult[i][2] = resultList.get(i).get(2);
            finalResult[i][3] = resultList.get(i).get(3);
        }

        return finalResult;
    }

    private void iterateLandArray(int[][] land, int noOfRows, int noOfColums) {
        while (!queue.isEmpty()) {
            CustomIndex customIndex = queue.poll();
            int i = customIndex.getI();
            int j = customIndex.getJ();
            visited[i][j] = true;

            if (intermediateList.isEmpty()) {
                intermediateList.add(i);
                intermediateList.add(j);
            }

            // Iterate left
            if (j - 1 >= 0) {
                if (land[i][j - 1] == 1 && !visited[i][j - 1]) {
                    queue.add(new CustomIndex(i, j - 1));
                }
            }

            // Iterate right
            if (j + 1 < noOfColums) {
                if (land[i][j + 1] == 1 && !visited[i][j + 1]) {
                    queue.add(new CustomIndex(i, j + 1));
                }
            }

            // Iterate top
            if (i - 1 >= 0) {
                if (land[i - 1][j] == 1 && !visited[i - 1][j]) {
                    queue.add(new CustomIndex(i - 1, j));
                }
            }

            // Iterate bottom
            if (i + 1 < noOfRows) {
                if (land[i + 1][j] == 1 && !visited[i + 1][j]) {
                    queue.add(new CustomIndex(i + 1, j));
                }
            }

            // Base condition
            if (queue.isEmpty()) {
                intermediateList.add(i);
                intermediateList.add(j);
            }
        }
    }
}

/* Acceped Solutions */

class Solution {
    int[] arr;
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<land.length;i++)
            for(int j=0;j<land[0].length;j++){
                if(land[i][j] == 1){
                    arr = new int[]{i,j,0,0};
                    dfs(land,i,j);
                    res.add(arr);
                }
            }
        return res.stream().map(i->i).toArray(int[][] :: new);
    }
    public void dfs(int[][] land, int i,int j){
        if(i<0 || j<0 || i>=land.length || j>= land[0].length || land[i][j] == 0) return;
        arr[2] = Math.max(i,arr[2]);
        arr[3] = Math.max(j,arr[3]);
        land[i][j] = 0;
        dfs(land,i-1,j);
        dfs(land,i,j+1);
        dfs(land,i+1,j);
        dfs(land,i,j-1);
    }
}