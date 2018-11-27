// DFS backtracking 回溯法(backtracking)在求解过程中不保留完整的树结构，而深度优先搜索(DFS)则记下完整的搜索树
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        DFS(list, tempList, nums);
        return list;
    }
    private void DFS(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList)); // 如果用list.add(tempList), 每次更新list时会把前面加入到templist一起覆盖
                                                 // 比如第一次加入123，list为123；第二次加入132时，此时list为132 132
            /* if a new list is not created e.g. if you do list.add(tempList) 
            then you are basically adding the same tempList (ArrayList) into list again and again, 
            and you will end up with list containing multiple references to the same tempList object.
            Since the algorithm performs tempList.remove(tempList.size() - 1) at the end of every iteration, 
            we will end up with an empty tempList at the end of the method 
            thus final result shows that list contains entries all pointing to the same empty tempList.*/
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
