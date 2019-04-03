class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> m = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        
        for (int i = 0; i < nums.length; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        
        q.addAll(m.entrySet());
        
        while(k > 0){
            res.add(q.poll().getKey());
            k--;
        }
        
        return res;
    }
}