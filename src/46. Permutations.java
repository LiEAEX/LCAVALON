// DFS backtracking
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        DFS(list, tempList, nums);
        return list;
    }
    private void DFS(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList)); // do not use list.add(tempList), the output will be [][][][]....
            /* if a new list is not created e.g. if you do list.add(tempList) 
            then you are basically adding the same tempList (ArrayList) into list again and again, 
            and you will end up with list containing multiple references to the same tempList object.*/
        } else{
            for(int i = 0; i < nums.length; i++){ 
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                DFS(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
