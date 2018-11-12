class Solution {
    public int firstMissingPositive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            m.put(nums[i], i);
        }
        int j = 1;
        while(m.containsKey(j)){
           j = j + 1; 
        }
        res = j;
        /*for (int i = 1; i <= nums.length; i++){
            if (!m.containsKey(i)){
                res = i;
                break;
            } 
        } */
      return res;  
    }
}