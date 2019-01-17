TreeMap API: "https://docs.oracle.com/javase/7/docs/api/"

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int n = difficulty.length, p = worker.length, res = 0, max = 0;
        for (int i = 0; i < n; i++){
            if (m.containsKey(difficulty[i]) && m.get(difficulty[i]) > profit[i]) continue;
            m.put(difficulty[i], profit[i]);
        }

        for (Integer key : m.keySet()) {
            max = Math.max(m.get(key), max);
            m.put(key, max);
        }
        
        Map.Entry<Integer, Integer> entry = null;
        for (int i = 0; i < p; i++) {
            entry = m.floorEntry(worker[i]);            
            if (entry != null) {
                res += entry.getValue();
            }  
        }
        return res;
    }
}

/*
        * TLE
        for (int i = 0; i < p; i++){
            while (worker[i] > 0){
                if(m.containsKey(worker[i])){
                    temp = Math.max(temp, m.get(worker[i]));
                }
                worker[i]--;
            }
            res += temp;
            temp = 0;
        }
        
        return res;*/