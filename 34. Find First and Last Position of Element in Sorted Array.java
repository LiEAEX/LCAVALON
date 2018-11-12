class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2 ;
            if (nums[mid] == target) {
                left = mid; 
                right = mid;
                while (left > 0 && nums[left - 1] == nums[mid]) --left;
                while (right < nums.length - 1 && nums[right + 1] == nums[mid]) ++right;
                break;
            }
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (left > right) {
            left = right = -1;
        }
        int[] res= {left,right};  
        return res;
    }
}  //O(logn)