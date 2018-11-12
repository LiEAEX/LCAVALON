class Solution {
    public int removeElement(int[] nums, int val) {
        int res = 0;
      for (int i=0 ; i < nums.length ; i++){
        if (nums[i] != val){
            nums[res] = nums[i];
            res = res + 1;
        }
        //if (nums[nums.length] == val) nums[nums.length] = nums[nums.length-1];
        
      }
    return res;
    }
}