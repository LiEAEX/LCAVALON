class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums [2];
        int diff = Math.abs(closest - target);
        Arrays.sort(nums);
        for (int i=0; i < nums.length-2; i++){
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums [right];
                int temp = Math.abs(sum - target);
                if (diff > temp){
                    diff = temp;
                    closest = sum;
                }
                if (sum < target) left++;
                else right--;
            }
        }
        return closest;
    }
}