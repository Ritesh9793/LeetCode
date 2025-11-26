class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int mod = 1_000_000_007;

        // dp[i][j][r] = number of ways to reach (i, j) with sum % k = r
        int[][][] dp = new int[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int r = 0; r < k; r++) {
                    int val = grid[i][j];

                    // From top
                    if (i > 0) {
                        int prevR = (r - val % k + k) % k;
                        dp[i][j][r] = (dp[i][j][r] + dp[i - 1][j][prevR]) % mod;
                    }

                    // From left
                    if (j > 0) {
                        int prevR = (r - val % k + k) % k;
                        dp[i][j][r] = (dp[i][j][r] + dp[i][j - 1][prevR]) % mod;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}
