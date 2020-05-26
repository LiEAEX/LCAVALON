Runtime: 2 ms, faster than 85.70% of Java online submissions for Set Mismatch.
Memory Usage: 41 MB, less than 71.43% of Java online submissions for Set Mismatch.

class Solution {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {    // 注意 nums[nums[i] - 1] 和 nums[i] 的关系 -> 数组性质
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

Runtime: 2 ms, faster than 85.70% of Java online submissions for Set Mismatch.
Memory Usage: 51.7 MB, less than 14.29% of Java online submissions for Set Mismatch.

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            cnt[nums[i]] += 1;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (cnt[i + 1] == 2) res[0] = i + 1;
            else if (cnt[i + 1] == 0) res[1] = i + 1;
        }
        return res;
    }
}



Runtime: 56 ms, faster than 5.08% of Java online submissions for Set Mismatch.
Memory Usage: 63.2 MB, less than 14.29% of Java online submissions for Set Mismatch.

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 1; i <= nums.length; i++){
            m.put(i, m.containsKey(i)? m.get(i) + 1 : 1);
            m.put(nums[i - 1], m.containsKey(nums[i - 1])? m.get(nums[i - 1]) - 1 : -1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (m.get(i) == 1) res[1] = i;
            else if (m.get(i) == -1) res[0] = i;
        }
        return res;
    }
}