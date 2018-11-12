class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        int l = nums.length;
        //int t = nums[0];
        HashMap<Integer,Integer> m = new HashMap <Integer,Integer>();
        
        if (target < nums[0]) return 0;
        if (target > nums[l-1]) return l;
        
        for (int i = 0; i < l; i++){
            m.put(nums[i],i);
        }
        
        if (m.containsKey(target)){
            res = m.get(target);
        }
        
        for (int i = 0; i < l; i++){
            if (target > nums[i] && target < nums[i+1]){
                res = i+1;
                break;
            }
        }
        return res; 
    }
}