class Solution {
    public List<List<Integer>> subsets(int[] nums) {       
        List<List<Integer>> res = new ArrayList<>();
        //if (nums.length == 0) return res;
        backtracking(nums, res, new ArrayList<>(), 0);
        return res;        
    }
    
    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> tempList, int start){
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtracking(nums, res, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}