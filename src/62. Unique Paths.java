class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 因只能每次向右或者下移动，状态转移方除为dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 0; i < m; i++) { //这一层循环相当于从上到下加
            for (int j = 0; j < n; j++) { // 这一层相当于从左到右加
                if (j > 0){
                    dp[j] += dp[j - 1]; // 每次dp[j]都会加上本身（上一层）和左边（j-1）
                }
            }
        }
        return dp[n-1];
    }
}