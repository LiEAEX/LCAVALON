class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> s = new HashSet<>();
        for (int a : nums){
            s.add(a);
        }
        
        int max = 0;

        for (int num : nums){
            if (s.remove(num)){
                int pre = num - 1, pos = num + 1;
                while (s.remove(pre)){
                    pre--;
                }
                while (s.remove(pos)){
                    pos++;
                }
                max = Math.max(max, pos - pre - 1);
            }
        }
        return max;        
    }
}