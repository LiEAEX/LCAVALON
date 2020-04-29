O(n), O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}




class Solution {
    public int firstMissingPositive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            m.put(nums[i], i);
        }
        int j = 1;
        while(m.containsKey(j)){
           j = j + 1; 
        }
        res = j;
        /*for (int i = 1; i <= nums.length; i++){
            if (!m.containsKey(i)){
                res = i;
                break;
            } 
        } */
      return res;  
    }
}
