O(logn):

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left+(right-left)/2;
            if (nums[mid] > nums[mid+1]) right = mid;
            if (nums[mid] < nums[mid+1]) left = mid+1;
        }
        return left;
    }
}

O(n):

class Solution {
    public int findPeakElement(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] > nums[i+1]){
                res = i;
                break;
            }
        }
        if (res == -1) res = nums.length-1;
        return res;
    }
}
