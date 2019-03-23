//  time is O(nlgn) and space is O(1)

class Solution {
    public int findDuplicate(int[] nums) {
	   int left = 1, right = nums.length - 1, mid;
	   while (left < right){
           mid = left + (right - left) / 2;
		   int count = 0;
		   for (int i = 0; i < nums.length; i++) {
			   if (nums[i] <= mid) count++;
		   }
		   if (count > mid){
               right = mid;
           }   
		   else if (count <= mid){
               left = mid + 1;
           }
	   }
	   return left; 
    }
}