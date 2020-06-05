class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> startIdx = new HashMap<>();
        HashMap<Integer, Integer> endIdx = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (!startIdx.containsKey(nums[i])) startIdx.put(nums[i], i);
            endIdx.put(nums[i], i);
        }
        
        int degree = 0;
        int res = 50000; // Integer.MAX_VALUE
        
        for (int num : nums) {
            degree = Math.max(degree, count.get(num));
        }
        
        for (int num : nums) {
            if (count.get(num) == degree) {
                res = Math.min(res, endIdx.get(num) - startIdx.get(num) + 1);
            }
        }
        
        return res;
    }
}