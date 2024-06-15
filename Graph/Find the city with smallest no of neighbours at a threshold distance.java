class CustomTuple {

    int destinationCity;
    int weightToReachCity;

    public CustomTuple(int i, int j) {
        this.destinationCity = i;
        this.weightToReachCity = j;
    }

    public int getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(int destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getWeightToReachCity() {
        return weightToReachCity;
    }

    public void setWeightToReachCity(int weightToReachCity) {
        this.weightToReachCity = weightToReachCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomTuple)) return false;
        CustomTuple that = (CustomTuple) o;
        return getDestinationCity() == that.getDestinationCity() && getWeightToReachCity() == that.getWeightToReachCity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDestinationCity(), getWeightToReachCity());
    }

    @Override
    public String toString() {
        return "CustomIndex{" +
                "i=" + destinationCity +
                ", j=" + weightToReachCity +
                '}';
    }
}

class Solution {

    Map<Integer, List<CustomTuple>> pathMapOfCities = new HashMap<>();
    Map<Integer, Set<Integer>> finalConnectedCitiesMap = new TreeMap<>();

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Making hashmap for the connected cities
        Arrays.stream(edges)
                .forEach(edge -> {
                    List<CustomTuple> connectedCitiesSource = pathMapOfCities.getOrDefault(edge[0], new ArrayList<>());
                    connectedCitiesSource.add(new CustomTuple(edge[1], edge[2]));
                    pathMapOfCities.put(edge[0], connectedCitiesSource);

                    List<CustomTuple> connectedCitiesDestination = pathMapOfCities.getOrDefault(edge[1], new ArrayList<>());
                    connectedCitiesDestination.add(new CustomTuple(edge[0], edge[2]));
                    pathMapOfCities.put(edge[1], connectedCitiesDestination);
                });

        IntStream.range(0, n)
                .forEach(range -> {
                    boolean[] visited = new boolean[n];
                    Arrays.fill(visited, false);
                    iterateEachCityWithinLimits(range, range, 0, distanceThreshold, visited);
                });

        Integer smallestCity = finalConnectedCitiesMap.entrySet()
                .stream()
                .min(
                        Comparator.comparing((Map.Entry<Integer, Set<Integer>> entry) -> entry.getValue().size())
                                .thenComparing((Map.Entry<Integer, Set<Integer>> entry) -> entry.getKey(), Comparator.reverseOrder())
                )
                .map((Map.Entry<Integer, Set<Integer>> entry) -> entry.getKey())
                .get();

        return smallestCity;
    }

    private void iterateEachCityWithinLimits(int parentCity, int cityToStart, int currentDistanceTravelled, int distanceThreshold, boolean[] visited) {
        if (currentDistanceTravelled <= distanceThreshold) {

            if (parentCity != cityToStart) {
                Set<Integer> finalConnectedCities = finalConnectedCitiesMap.getOrDefault(parentCity, new HashSet<>());
                finalConnectedCities.add(cityToStart);
                finalConnectedCitiesMap.put(parentCity, finalConnectedCities);
            }
            visited[cityToStart] = true;

            List<CustomTuple> connectedCitiesList = pathMapOfCities.get(cityToStart);
            if (Objects.nonNull(connectedCitiesList)) {
                connectedCitiesList.stream()
                        .forEach(connectedCity -> {
                            if (!visited[connectedCity.getDestinationCity()]) {
                                iterateEachCityWithinLimits(parentCity, connectedCity.getDestinationCity(), currentDistanceTravelled + connectedCity.getWeightToReachCity(), distanceThreshold, visited);
                                visited[connectedCity.getDestinationCity()] = false;
                            }
                        });
            } else {
                finalConnectedCitiesMap.put(cityToStart, new HashSet<>());
            }

        }
    }
}

// Accepted Code but a little bit slight changing approach

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    
    ArrayList<int []>[] graph = new ArrayList[n];
    for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    for(int []edge : edges){
        graph[edge[0]].add(new int[]{edge[1],edge[2]});
        graph[edge[1]].add(new int[]{edge[0],edge[2]}); 
    }
    int city = 0;
    int min = n+1; // min can't be greater than n+1;
    
    for(int i=0;i<n;i++){
        int count = bfs(graph,i,distanceThreshold); // do bfs from every node to find out the min number of nodes it visits
        if(count <= min){
            city = i;
            min = count;
        }
    }
    return city;
}
private int bfs(ArrayList<int[]>[] graph,int src,int k){
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
    pq.add(new int[]{src,0});
    boolean []vis = new boolean[graph.length];
    int countNodes = -1;  // can be initilaized with zero too (-1 taken to not include the source node)
    while(pq.size()!=0){
        
        int []temp = pq.poll();
        if(vis[temp[0]])continue;
        vis[temp[0]]=true;
        countNodes++;
        for(int []nbr : graph[temp[0]]){
            if(vis[nbr[0]] != true && nbr[1]+temp[1] <= k){ // add only if the totoal distance is at most threshold
                pq.add(new int[]{nbr[0],nbr[1]+temp[1]});
            }
        }
    }
    return countNodes; 
}
}