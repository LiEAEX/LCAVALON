DP

recursion solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }
    
    // rem: remaining amount after the last step; 
    // count[rem - 1]: minimum number of coins to sum up to rem
    private int helper(int[] coins, int rem, int[] count){
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (count[rem - 1] != 0) return count[rem - 1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        
        // for each certain rem, try all kinds of coin to get the minimum
        for (int coin : coins) {
            int temp = helper(coins, rem - coin, count);
            if (temp >= 0 && temp < min){
                min = 1 + temp;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        
        return count[rem - 1];
    }
}

iterative solution, bottom-up

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int coin:coins){
               if(i-coin>=0 && dp[i-coin] != -1)
                   min = dp[i-coin] < min ? dp[i-coin] :min; 
            }
            // Set dp[i] to -1 if i (current amount) can not be reach by  coins array
            dp[i] = min== Integer.MAX_VALUE ? -1 : 1+min;
        }
        return dp[amount];
    }
}