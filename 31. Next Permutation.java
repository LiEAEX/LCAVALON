class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, k, l;
        for (k = n - 2; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                break;//traverse backward
                      //elements from num[k+1] to num[n-1] is reversely sorted 
            }
        }
        if (k < 0) { //the whole nums is reversely sorted
            reverse(nums, 0, n - 1); // just reverse all of them
        } else {
            for (l = n - 1; l >= 0; l--) {
                if (nums[k] < nums[l]) {
                    break;
                }
            }
            swap(nums, k, l);
            reverse(nums, k + 1, n - 1);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}