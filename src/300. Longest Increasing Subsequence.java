DP:

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}

O(n log n)
Binary Search:
// https://leetcode.com/problems/longest-increasing-subsequence/discuss/74880/JAVA-Easy-Version-To-Understand!!!!!!!!
// http://www.cnblogs.com/grandyang/p/4938187.html


class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int n = nums.length, len = 0;
        int[] increasingSequence = new int[n];
        increasingSequence[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > increasingSequence[len - 1])
                increasingSequence[len++] = nums[i];
            else {
                int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
                increasingSequence[position] = nums[i];
            }
        }
        return len;
    }
    
    public static int findPositionToReplace(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x) return mid;
            else if (a[mid] > x) high = mid - 1;
            else if (a[mid] < x) low = mid + 1;
        }
        return low;
    }

}