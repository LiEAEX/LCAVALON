class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != nums[j]) {
                j = j + 1;
                nums[j] = nums[i];
            } //nums[++j] = nums[i];
        }
        return j + 1;
    }
}
//最开始时两个指针都指向第一个数字，如果两个指针i,j指的数字相同，则快指针i向前走一步，如果不同，则两个指针都向前走一步,然后进行值的替换