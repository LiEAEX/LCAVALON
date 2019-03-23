class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();        
        Map<String, Integer> m = new HashMap<>();
        for (String str : words){
            m.put(str, m.getOrDefault(str, 0) + 1);
        }
        
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a,b) -> (a.getValue() == b.getValue()? a.getKey().compareTo(b.getKey()):b.getValue() - a.getValue())); //decent order
        
        q.addAll(m.entrySet());
        
        while (k > 0){
            res.add(q.poll().getKey());
            k--;
        }
        
        return res;
    }
}