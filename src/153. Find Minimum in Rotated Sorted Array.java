class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                return nums[i];
            }            
        }
        return nums[0];
    }
}


class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) { 
                h = m;
            } else {
                l = m + 1;
        }
    }
        return nums[h];
    }
}