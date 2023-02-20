class Solution {

    private List<Integer>[] adj;
    private long fuel = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {

        // Adjacency List Creation
        int n = roads.length + 1;
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            adj[r[0]].add(r[1]);
            adj[r[1]].add(r[0]);
        }

        /*
        *  If(people at a node <= seats) : Add people/seats
        *  Else                          : Add ( people/seats ) + 1
        * */
        
        // Call dfs to get respective people and the fuel consumed 
        dfs(0, -1, seats);
        return fuel;
    }

    private int dfs(int node, int parent, int seats) {
        int people = 1;
        for (int child : adj[node]) {
            if (child != parent) {
                people += dfs(child, node, seats);
            }
        }
        if (node != 0) {
            fuel += Math.ceil(people * 1.0 / seats);
        }

        return people;
    }
}