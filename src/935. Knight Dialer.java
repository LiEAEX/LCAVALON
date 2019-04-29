Runtime: 49 ms, faster than 43.86% of Java online submissions for Knight Dialer.
Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Knight Dialer.

class Solution {
    public int knightDialer(int N) {
        int[][] map = new int[][]{{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        // must use N+1 instead of N(cause out of boundary)
        // 0,1,2,...,N -> N+1
        int[][] memo = new int[N+1][10]; 
        for (int[] init : memo){
            Arrays.fill(init, -1);
        }
        
        int res = 0;
        for (int start = 0; start < 10; start++){
            res += dfs(map, memo, start, N);
            res %= (int)1e9+7;
        }
        return res;
    }
    
    private int dfs(int[][] map, int[][] memo, int s, int n){
        if (n == 1) return 1;
        if (memo[n][s] != -1) return memo[n][s];
        
        memo[n][s] = 0; // reset to zero
        for (int next : map[s]){
            memo[n][s] += dfs(map, memo, next, n-1);
            memo[n][s] %= (int)1e9+7;
        }
        return memo[n][s];
    }
}

Runtime: 18 ms, faster than 92.02% of Java online submissions for Knight Dialer.
Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Knight Dialer.

class Solution {
    public int knightDialer(int N) {
        // use long since the size is too huge
        if (N==1) return 10;
        long[] cur= new long[10];
        Arrays.fill(cur, 1);
        cur[5]=0;
        long res=0, M=(int)1e9+7;;
        // "-->" is just a conjunction of the operators -- and >.
        // N-->1 simply means N > 1; N--; Compare and decrement
        while (N-->1){
            long[] next= Arrays.copyOf(cur, 10);
            next[0]=(cur[4]+cur[6])%M;
            next[1]=(cur[6]+cur[8])%M;
            next[2]=(cur[7]+cur[9])%M;
            next[3]=(cur[4]+cur[8])%M;
            next[4]=(cur[3]+cur[9]+cur[0])%M;
            next[6]=(cur[1]+cur[7]+cur[0])%M;
            next[7]=(cur[2]+cur[6])%M;
            next[8]=(cur[1]+cur[3])%M;
            next[9]=(cur[2]+cur[4])%M;
            cur=next;
        }
        for (long n: cur) res=(res+n)%M;
        return (int)res;
    }
}
