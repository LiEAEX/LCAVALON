// Dynamic Programming Approach
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        int n = height.length;
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        dpLeft[0] = height[0];
        dpRight[n-1] = height[n-1];
        for(int i = 1; i < n; i++) {
            dpLeft[i] = height[i] > dpLeft[i-1] ? height[i] : dpLeft[i-1];
            dpRight[n-i-1] = height[n-i-1] > dpRight[n-i] ? height[n-i-1] : dpRight[n-i];
        }
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += Math.min(dpLeft[i], dpRight[i]) - height[i];
        }
        return total;
    }
}

Key idea is to keep a track of the highest walls on the left and the right and narrowing down from both sides. 
As we narrow down keeping adding to the result, the water trapped in unit width and smaller of each walls on each move.
/*
这种方法是基于动态规划Dynamic Programming的，我们维护一个一维的dp数组，这个DP算法需要遍历两遍数组，第一遍遍历dp[i]中存入i位置左边的最大值，然后开始第二遍遍历数组，第二次遍历时找右边最大值，然后和左边最大值比较取其中的较小值，然后跟当前值A[i]相比，如果大于当前值，则将差值存入结果
*/
    
class Solution {
    public int trap(int[] height) {
        int a = 0, b = height.length-1;
        int max = 0, leftmax = 0, rightmax = 0;
        while(a <= b){
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if(leftmax < rightmax){
                max += (leftmax - height[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max; 
    }
} 
