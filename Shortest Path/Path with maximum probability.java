class TraversalNode {
    int destination;
    double probabilityCost;

    public TraversalNode(int destination, double probabilityCost) {
        this.destination = destination;
        this.probabilityCost = probabilityCost;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public double getProbabilityCost() {
        return probabilityCost;
    }

    public void setProbabilityCost(double probabilityCost) {
        this.probabilityCost = probabilityCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TraversalNode)) return false;
        TraversalNode that = (TraversalNode) o;
        return getDestination() == that.getDestination() && getProbabilityCost() == that.getProbabilityCost();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDestination(), getProbabilityCost());
    }

    @Override
    public String toString() {
        return "EffortNode{" +
                ", column=" + destination +
                ", effort=" + probabilityCost +
                '}';
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        // Initialising traversal map for all the edges
        Map<Integer, List<TraversalNode>> traversalMap = new HashMap<>();
        IntStream.range(0, edges.length)
                .forEach(index -> {
                    List<TraversalNode> traversalNodeListFromFirstNode = traversalMap.getOrDefault(edges[index][0], new ArrayList<>());
                    traversalNodeListFromFirstNode.add(new TraversalNode(edges[index][1], succProb[index]));
                    traversalMap.put(edges[index][0], traversalNodeListFromFirstNode);

                    List<TraversalNode> traversalNodeListFromSecondNode = traversalMap.getOrDefault(edges[index][1], new ArrayList<>());
                    traversalNodeListFromSecondNode.add(new TraversalNode(edges[index][0], succProb[index]));
                    traversalMap.put(edges[index][1], traversalNodeListFromSecondNode);
                });


        double[] dist = new double[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MIN_VALUE);
        Arrays.fill(visited, Boolean.FALSE);
        dist[start_node] = 0;

        // Iterate over all the vertices and find the shortest path
        traversalMap.entrySet().stream()
                .forEach(map -> {

                    // Find the maximum distance vertex not included in the mstSet yet and mark it as visited
                    int maxDistanceVertex = findMaxDistance(dist, visited);
                    if (maxDistanceVertex != -1) {
                        visited[maxDistanceVertex] = Boolean.TRUE;
                        List<TraversalNode> adjacentVerticesOfCurrentNode = traversalMap.getOrDefault(maxDistanceVertex, new ArrayList<>());

                        // Relax all the adjacent vertices
                        adjacentVerticesOfCurrentNode.stream()
                                .forEach(
                                        adjacentNode -> {
                                            if (!visited[adjacentNode.getDestination()] && dist[maxDistanceVertex] != Integer.MAX_VALUE) {
                                                double maxDistance = dist[maxDistanceVertex];
                                                double currentAdjacentDistance = maxDistance == 0 ? adjacentNode.getProbabilityCost() : maxDistance * adjacentNode.getProbabilityCost();
                                                if (dist[adjacentNode.getDestination()] < currentAdjacentDistance) {
                                                    dist[adjacentNode.getDestination()] = currentAdjacentDistance;
                                                }
                                            }
                                        }
                                );
                    }
                });

        return dist[end_node] == Integer.MIN_VALUE ? 0 : dist[end_node];
    }

    
    private int findMaxDistance(double[] dist, boolean[] visited) {
        int maxDistanceIndex = IntStream.range(0, dist.length)
                .filter(index -> !visited[index] && dist[index] != Integer.MIN_VALUE)
                .reduce(0, (soFarGreatestIndex, toCheckForGreatestIndex)
                        -> (dist[soFarGreatestIndex] > dist[toCheckForGreatestIndex]) ? soFarGreatestIndex : toCheckForGreatestIndex);

        return (maxDistanceIndex == 0 && dist[0] == Integer.MIN_VALUE) ? -1 : maxDistanceIndex;
    }
}

// Accepted Code
// Making the class Pair for storing the solution
class Pair{
    int node;
    double probability;
    Pair(int node,double probability){
        this.node = node;
        this.probability = probability;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // Making the adjaceny list where we are storing the Pair of neighbor and their probability reaching their for every node 
        List<List<Pair>> list = new ArrayList<>();

        for(int i=0;i<n;i++) list.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            list.get(u).add(new Pair(v,prob));
            list.get(v).add(new Pair(u,prob));
        }

        // Here we are going to store the best probability for every node
        double[] distance = new double[n];
        Arrays.fill(distance,0.0);
        distance[start] = 1;

        // Starting with the start node
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int curr_node = queue.poll();
            List<Pair> neighbor_list = list.get(curr_node);
            // getting all the pairs of neighbor nodes and their probabilities respectively 
            for(Pair pair:neighbor_list){
                int neighbor = pair.node;
                double prob = pair.probability;
                double new_prob = distance[curr_node]*prob;
                // if the new probability is greater than the existing one
                if(new_prob>distance[neighbor]){
                    distance[neighbor] = new_prob;
                    queue.add(neighbor);
                }

            }
        }

        // returning the end node 
        return distance[end];
    }
}