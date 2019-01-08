// DP solution
// Bottom-Up should look like f(i,j) = min(f(i-1,j),f(i,j-1),f(i-1,j-1)) + 1

class Solution {
    //cost(i, j): minimum cost required to convert first i characters of word1 to first j characters of word2
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] cost = new int[m+1][n+1];
        // base 
        for (int i = 0; i <= m;i++){
            cost[i][0] = i; 
        }
        
        for (int j = 0; j <= n;j++){
            cost[0][j] = j;
        }
        
        // for String comparing, we must make i,j below the border
        // thus we have add 1 to every i and j in the cost array
        // to perform bottom-up iteration
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (word1.charAt(i) == word2.charAt(j)){
                    cost[i+1][j+1] = cost[i][j];
                } else {
                    int add = cost[i][j+1];
                    int delete = cost[i+1][j];
                    int rep = cost[i][j];
                    cost[i+1][j+1] = Math.min(Math.min(add, delete), rep) + 1;
                }
            }
        }
        return cost[m][n];
    }
}