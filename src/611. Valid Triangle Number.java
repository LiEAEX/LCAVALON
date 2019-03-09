Runtime: 13 ms, faster than 96.05% of Java online submissions for Valid Triangle Number.
Memory Usage: 39.3 MB, less than 69.32% of Java online submissions for Valid Triangle Number.

class Solution {
    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums.length < 3) return result;
        
        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += (right - left); // nums[right]和大于等于left的所有nums[left]都能和nums[i]构成三角形
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        
        return result;
    }
}

Memory Limit Exceeded： RIP.... 

class Solution {
    public int triangleNumber(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();
        int res = 0;
        
        backtracking(nums, permutation, 0, new ArrayList<>());
        
        for (List a : permutation){
            if (checkTriangle(a)) res++;
        }
        return res;
    }
    
    private void backtracking(int[] nums, List<List<Integer>> permutation, int n, ArrayList<Integer> temp){
        if (temp.size() == 3){
            permutation.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = n; i < nums.length; i++){
            temp.add(nums[i]);
            backtracking(nums, permutation, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
    
    private boolean checkTriangle(List<Integer> a){
        return (a.get(0) + a.get(1) > a.get(2)) && (a.get(0) + a.get(2) > a.get(1)) && (a.get(1) + a.get(2) > a.get(0));
    }
}