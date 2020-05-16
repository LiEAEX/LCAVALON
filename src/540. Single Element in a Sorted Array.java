// 二分

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = l + (h - l) / 2;
            if (m % 2 == 1){
                m--; // make m even
            }
            if (nums[m] == nums[m + 1]){
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[h]; // or nums[l], because in the end of loop, l = h
    }
}