class Solution {
    public int minPathSum(int[][] grid) {
        // get mxn sizes
        int m = grid.length;
        int n = grid[0].length;

        // dp array
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // handle first column
        for (int i = 1; i < m; i++) {
            // add one before it
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        // handle first row
        for (int i = 1; i < n; i++) {
            // add one before it
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        // starting from (1,1) iterate thru array taking min path choices along the way
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp value at this coordinate is lesser of the two possible paths
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // the result should be at the bottom right corner of DP array
        return dp[m - 1][n - 1];
    }
}
