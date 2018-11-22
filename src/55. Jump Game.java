class Solution {       //Greedy
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = 0;
        for (int i = 0; i < n; i++) {
            if (i > reach || reach >= n - 1) break;
            reach = Math.max(reach, i + nums[i]);
        }   // only concern about the furthest position that we can reach from current position
        return reach >= n - 1;
    }
}