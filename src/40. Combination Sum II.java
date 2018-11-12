class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(res, new ArrayList<>(), candidates, target, 0);
        List<List<Integer>> newList = new ArrayList<>(); 
        for (List<Integer> a:res) {
            if(!newList.contains(a)) newList.add(a);
        }
        return newList;
    }
    
    private void DFS(List<List<Integer>> res, List<Integer> templist, int[] candidates, int remain, int start){
        if (remain == 0) res.add(new ArrayList(templist));
        else if (remain < 0) return;
        else{
            for (int i = start; i < candidates.length; i++){
                templist.add(candidates[i]);
                DFS(res, templist, candidates, remain - candidates[i], i+1);
                templist.remove(templist.size() - 1);
            }
        }
    }
}