Time complexity O(K * N * N)

class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        // dp[i][j] i:city j:week
        int[][] dp = new int[n][k];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < k; j++){
                dp[i][j] = -1;
            }
        }
        
        // initial
        dp[0][0] = days[0][0];
        for (int i = 0; i < n; i++){
            if (flights[0][i] == 1){
                dp[i][0] = days[i][0];
            }
        }
        
        // DP
        for (int week = 1; week < k; week++){
            for (int next = 0; next < n; next++){
                for (int cur = 0; cur < n; cur++){
                    if (dp[cur][week-1] == -1) continue;
                    if (flights[cur][next] == 1 || cur == next){
                        dp[next][week] = Math.max(dp[next][week], days[next][week]+dp[cur][week-1]); 
                    } 
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; i++){
            res = Math.max(res, dp[i][k-1]);
        }
        
        return res;
    }
}


DFS TLE: Time limit Exceeded

public class Solution {
    int max = 0, N = 0, K = 0;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        N = flights.length;
        K = days[0].length;
        dfs(flights, days, 0, 0, 0);
        
        return max;
    }
    
    private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
        if (week == K) {
            max = Math.max(max, sum);
            return;
        }
        
        for (int dest = 0; dest < N; dest++) {
            if (curr == dest || f[curr][dest] == 1) {
                dfs(f, d, dest, week + 1, sum + d[dest][week]);
            }
        }
    }
}