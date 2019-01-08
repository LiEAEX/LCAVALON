class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int prevPos = nums[0];
        int prevNeg = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++){
            int pos = prevPos * nums[i];
            int neg = prevNeg * nums[i];
            prevPos = Math.max(nums[i], Math.max(neg, pos));
            prevNeg = Math.min(nums[i], Math.min(neg, pos));
            res = Math.max(res, prevPos);
        }
        return res;
    }
}

/*
    if (n == 1) return nums[0];
    int[] f = new int[nums.length];
    int[] g = new int[nums.length];
    f[0] = nums[0];
    g[0] = nums[0];
    int res = A[0];
    for (int i = 1; i < A.length; i++) {
        f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
        g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
        res = Math.max(res, f[i]);
    }
    return res;
*/

