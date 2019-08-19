DFS：

class Solution {
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] memo = new double[N][N][K+1];
        return (double)dfs(r, c, memo, K, N)/Math.pow(8, K); 
    }
    
    private double dfs(int tr, int tc, double[][][] memo, int K, int N){
        if (tr < 0 || tr > N-1 || tc < 0 || tc > N-1) return 0.0;
        if (K == 0) return 1.0;
        if (memo[tr][tc][K] != 0) return memo[tr][tc][K];
        
        double res = dfs(tr-2, tc+1, memo, K-1, N)+dfs(tr-1, tc+2, memo, K-1, N)+dfs(tr+1, tc+2, memo, K-1, N)+dfs(tr+2, tc+1, memo, K-1, N)+dfs(tr+2, tc-1, memo, K-1, N)+dfs(tr+1, tc-2, memo, K-1, N)+dfs(tr-1, tc-2, memo, K-1, N)+dfs(tr-2, tc-1, memo, K-1, N);
        
        memo[tr][tc][K] = res;
        
        return res;
    }
}

DP:

class Solution {
        private int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        public double knightProbability(int N, int K, int r, int c) {
            double[][][] dp = new double[K + 1][N][N];
            dp[0][r][c] = 1;
            for (int step = 1; step <= K; step++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        for (int[] dir : dirs) {
                            int x = dir[0] + i;
                            int y = dir[1] + j;
                            if (x < 0 || x >= N || y < 0 || y >= N) continue;
                            dp[step][x][y] += dp[step - 1][i][j] * 0.125;
                        }
                    }
                }
            }
            double res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    res += dp[K][i][j];
                }
            }
            return res;
        }
}

BFS : TLE

class Solution {
    
    public class Pair{
        int row;
        int col;
        Pair(){
            row = 0;
            col = 0;
        }
        Pair(int a, int b){
            row = a;
            col = b;
        }
    }
    
    public double knightProbability(int N, int K, int r, int c) {
         
        Queue<Pair> q = new LinkedList<>();
        double all = Math.pow(8, K);
        double res = 0;
        if (K == 0) res = 1;
        Pair pr = new Pair(r, c);
        q.offer(pr);
        while (!q.isEmpty() && K > 0){
            int len = q.size();
            double cnt = 0;
            for (int i = 0; i < len; i++){
                Pair temp = q.poll();
                int tr = temp.row;
                int tc = temp.col;
                if (tr-2 >= 0 && tc+1 < N){
                    q.offer(new Pair(tr-2, tc+1));
                    cnt++;
                }
                if (tr-1 >= 0 && tc+2 < N){
                    q.offer(new Pair(tr-1, tc+2));
                    cnt++;
                }
                if (tr+1 < N && tc+2 < N){
                    q.offer(new Pair(tr+1, tc+2));
                    cnt++;
                }
                if (tr+2 < N && tc+1 < N){
                    q.offer(new Pair(tr+2, tc+1));
                    cnt++;
                }
                if (tc-1 >= 0 && tr+2 < N){
                    q.offer(new Pair(tr+2, tc-1));
                    cnt++;
                }
                if (tc-2 >= 0 && tr+1 < N){
                    q.offer(new Pair(tr+1, tc-2));
                    cnt++;
                }
                if (tr-1 >= 0 && tc-2 >= 0){
                    q.offer(new Pair(tr-1, tc-2));
                    cnt++;
                }
                if (tr-2 >= 0 && tc-1 >= 0){
                    q.offer(new Pair(tr-2, tc-1));
                    cnt++;
                }
            }
            res = cnt;
            K--;
        }
        
        return res/all;
    }
}