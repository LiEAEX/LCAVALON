//DP bottom up
class Solution {
    public int climbStairs(int n) {
        int[] stair = new int[n];
        if (n < 2) return 1;
        stair[0] = 1;
        stair[1] = 2;
        for (int i = 2; i < n; i++){
            stair[i] = stair[i - 1] + stair[i - 2];
        }
        return stair[n - 1];
    }    
}
