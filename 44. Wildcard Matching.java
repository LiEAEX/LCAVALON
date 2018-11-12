class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base cases: 
        dp[0][0] = true;                  //origin: dp[0][0]: they do match, so dp[0][0] = true
        for(int i = 1; i <= m; i++){      //first column: dp[i][0]: can't match when p is empty. All false.
            dp[i][0] = false;
        }       
        for(int j = 1; j <= n; j++){      //first row: dp[0][j]: except for String p starts with *, otherwise all false
            if(p.charAt(j-1) == '*'){     //if there exists one that is not *, all the dp[0][j] after it will be false
                dp[0][j] = dp[0][j-1];
            }            
        }
        
        // Recursion: Iterate through every dp[i][j]
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if((s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') && dp[i-1][j-1])
                    dp[i][j] = true;
                else if (p.charAt(j-1) == '*' && (dp[i-1][j] || dp[i][j-1]))
                    dp[i][j] = true;
            }
        }
        return dp[m][n];
    }
}
/*dp[i][j] = true:
if (s[ith] == p[jth] || p[jth] == '?') && dp[i-1][j-1] == true 
elif p[jth] == '*' && (dp[i-1][j] == true || dp[i][j-1] == true) 
-for dp[i-1][j], means that * acts like an empty sequence. 
eg: ab, ab*
-for dp[i][j-1], means that * acts like any sequences
eg: abcd, ab*
Start from 0 to length
Output put should be dp[s.len][p.len], referring to the whole s matches the whole p
*/