array and binary search solution:

class Solution {
    
    Random random;
    int[] weightSum;

    public Solution(int[] w) {
        random = new Random();
        for (int i = 0; i < w.length-1; i++){
            w[i + 1] += w[i];
        }
        weightSum = w;
    }
    
    public int pickIndex() {
        int idx = random.nextInt(weightSum[weightSum.length-1])+1;
        int left = 0;
        int right = weightSum.length - 1;
        int mid = 0;
        while (left < right){
            mid = left + (right - left)/2;
            if (weightSum[mid] == idx) return mid;
            else if (weightSum[mid] < idx) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

TreeMap Solution:

 class Solution {
    
    Random random;
    TreeMap<Integer, Integer> tm;
    int cnt = 0;

    public Solution(int[] w) {
        random = new Random();
        tm = new TreeMap<>();
        for (int i = 0; i < w.length; i++){
            cnt += w[i];
            tm.put(cnt, i);
        }
        
    }
    
    public int pickIndex() {
        // int key= tm.ceilingKey(rnd.nextInt(cnt)+1); don't forget to +1, 
        // because rand.nextInt(cnt) generate random integer in range [0,cnt-1]
        int key = tm.higherKey(random.nextInt(cnt));
        return tm.get(key);
    }
}