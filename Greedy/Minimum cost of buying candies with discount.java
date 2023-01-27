class Solution {
    public int minimumCost(int[] cost) {
      int counter = 0;
        int minCost = 0;
        Arrays.sort(cost);

        for (int i = cost.length - 1; i >= 0; i--) {
            if (counter == 2) {
                counter = 0;
                continue;
            }

            minCost += cost[i];
            counter++;
        }

        return minCost;
  
    }
}