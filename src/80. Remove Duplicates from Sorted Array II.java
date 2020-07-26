Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
Memory Usage: 39.7 MB, less than 47.02% of Java online submissions for Remove Duplicates from Sorted Array II.

class Solution {
    public int removeDuplicates(int[] nums) {
        int limit = 2;
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;
        
        int slow = 1, cnt = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) {
                if (cnt < limit) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                cnt++;
            } else {
                cnt = 1;
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}