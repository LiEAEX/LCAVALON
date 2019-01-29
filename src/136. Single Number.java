class Solution { //10ms
    public int singleNumber(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++){
            if (m.get(nums[i]) == 1) res = nums[i];
        }
        return res;
    }
}

class Solution {  0ms beat 100%
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums){
            res = res ^ num;   ^ : 异或
        }
        return res;
    }
}