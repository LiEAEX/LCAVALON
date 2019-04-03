Binary Search
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
Memory Usage: 40 MB, less than 5.03% of Java online submissions for Search Insert Position.

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums[0] == target || nums.length == 1 && nums[0] > target) return 0;
        if (nums.length == 1 && nums[0] < target) return 1;
        
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
