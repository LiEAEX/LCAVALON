class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int first = findTarget(nums, target);
        int last = findTarget(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        return new int[]{first, Math.max(first, last)};
        
    }
    
    public int findTarget(int[] nums, int target){
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target){
                h = m;
            } else {
                l = m + 1;
            }
        }
        return h;
    }
}

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
