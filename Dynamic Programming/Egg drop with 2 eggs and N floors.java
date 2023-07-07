class Solution {
    /*
    * It is a work estimation problem.
    * Best choice of the worst luck -> Min of the max
    * e|f -> if survives : e|f-k  -> if breaks : e-1|k-1 when k is the floor
    * References - https://www.youtube.com/watch?v=UvksR0hR9nA 
    * */

    public int twoEggDrop(int n) {

        int[][] dp = new int[3][n + 1];
        for (int i = 1; i <= 2; i++)
            for (int j = 1; j <= n; j++) {
                if (i == 1)
                    dp[i][j] = j;
                else if (j == 1)
                    dp[i][j] = 1;
                else {
                    int min = Integer.MAX_VALUE;

                    for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
                        int v1 = dp[i][mj]; // egg survives
                        int v2 = dp[i - 1][pj]; // egg breaks
                        int val = Math.max(v1, v2);
                        min = Math.min(val, min);
                    }
                    dp[i][j] = min + 1;
                }
            }

        return dp[2][n];
    }


}