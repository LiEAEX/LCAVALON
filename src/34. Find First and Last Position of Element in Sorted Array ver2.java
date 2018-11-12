class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx = search(nums, 0, nums.length - 1, target);
        if (idx == -1) {
            int[] res = {-1, -1};
            return res;
        }
        int left = idx, right = idx;
        while (left > 0 && nums[left - 1] == nums[idx]) --left;
        while (right < nums.length - 1 && nums[right + 1] == nums[idx]) ++right;
        int[] res = {left, right};
        return res; 
    }
    
    int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return search(nums, mid + 1, right, target);
        else return search(nums, left, mid - 1, target);
    }
}
// O(logn), worst case O(n)