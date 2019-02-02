class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ((nums == null || nums.length == 0) && k == 0) return new int[0];
        int n = nums.length - k + 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            res[i] = pickMax(nums, i, i + k - 1);
        }
        return res;
    }
    
    private int pickMax(int[] nums, int a, int b){
        int tp = Integer.MIN_VALUE;
        for (int i = a; i <= b; i++){
            tp = Math.max(tp, nums[i]);
        }
        return tp;
    }
}