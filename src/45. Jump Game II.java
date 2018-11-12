class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0, cur = 0;
        int i = 0;
        while (cur < n - 1) {
            ++count;         // cur为现在一跳能到达的最远位置
            int pre = cur;   // pre为之前一跳能到达的最远位置
            for (; i <= pre; ++i) {
                cur = Math.max(cur, i + nums[i]);
            }
            //if (pre == cur) return -1; // May not need this
        }
        return count;
    }
}