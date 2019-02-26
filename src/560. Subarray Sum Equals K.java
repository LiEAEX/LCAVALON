class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> ps = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if (sum == k) res++; // 处理sum-k=0的情况
            if (ps.containsKey(sum - k)){
                res = res + ps.get(sum - k);
            }
            ps.put(sum, ps.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> ps = new HashMap<>();
        ps.put(0, 1); // 处理sum=k的情况
        
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if (ps.containsKey(sum - k)){
                res = res + ps.get(sum - k);
            }
            ps.put(sum, ps.getOrDefault(sum, 0) + 1);
        }        
        return res;
    }
}