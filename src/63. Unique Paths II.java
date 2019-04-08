Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.


DP Solution:

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {   
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                } 
                else if (j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n-1];
    }
}

DFS TLE:

class Solution {
    int res = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
        dfs(0, 0, obstacleGrid);
        return res;
    }
    
    private void dfs(int i, int j, int[][] obstacleGrid){
        if (i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
            res++;
            return;
        }
        if (i+1 < obstacleGrid.length && obstacleGrid[i+1][j] != 1) dfs(i+1, j, obstacleGrid);
        if (j+1 < obstacleGrid[0].length && obstacleGrid[i][j+1] != 1) dfs(i, j+1, obstacleGrid);
    }
}