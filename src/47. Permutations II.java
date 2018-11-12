class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        DFS(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> templist, int[] nums, boolean [] used){
        if (templist.size() == nums.length) res.add(new ArrayList<>(templist));
        else {
            for (int i = 0; i < nums.length; i++){
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) continue;
                used[i] = true;
                templist.add(nums[i]);
                DFS(res, templist, nums, used);
                used[i] = false;
                templist.remove(templist.size() - 1);
            }
        }
    }
}
/*assume permutating [1,2,2,3]. 
Talking about 2 at index 2, we could have been here as part of path: [1->2->2] 
in which case previous 2 at index 1 would be a parent to us so used[i-1] = true in this case. 
However we could also have been here as part of path [1---->2] which is a direct path from 1. 
In this case previous 2 at index 1 is not a parent of this particular permutation 
therefore used[i - 1] = false so that we skip it to avoid duplicates*/