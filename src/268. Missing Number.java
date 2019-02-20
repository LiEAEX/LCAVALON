class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;
            
        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }
}

Binary Search:

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int res = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i != nums[i]){
                res = i;
                break;
            }
        }
        if (res == -1) res = nums.length;
        return res;        
    }
}