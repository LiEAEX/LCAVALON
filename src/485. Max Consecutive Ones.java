class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0;
        for (int num : nums) {
            cur = num == 0 ? 0 : cur + 1;
            res = Math.max(res, cur); 
        }
        return res;
    }
}