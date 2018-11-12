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