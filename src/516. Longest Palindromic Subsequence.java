DP:
// It is easy to observe dp[i][j] depends on dp[i+1][j-1] <-- case1 
// and dp[i+1][j] <-- case 2 and dp[i][j-1] <-- case 3. 
// So to fill current cell in the dp array we look left, down and down-left. 
// That is, we need to fill from the bottom up and left to right fashion

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = n-1; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}

LCS:

class Solution {
    public int longestPalindromeSubseq(String s) {
        int res = 0;
        StringBuilder temp = new StringBuilder(s);
        temp = temp.reverse();
        String rs = temp.toString();
        int n = s.length(), m = rs.length();
        int[][] lcs = new int[n+1][m+1];
        for (int i = 0; i < n; i++) lcs[i][0] = 0;
        for (int j = 0; j < m; j++) lcs[0][j] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (s.charAt(i-1) == rs.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                if (s.charAt(i-1) != rs.charAt(j-1)){
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            } 
        }
        
        return lcs[n][m];
    }    
}