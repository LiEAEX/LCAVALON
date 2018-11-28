class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        if(s.length() < 1) return 0;
        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        int t1 = 0;
        int t2 = 0;
        int res = 0;
        while(t2 < s.length()) {
            if(index.size() <= 2) { // Returns the number of key-value mappings in this map.
                char c = s.charAt(t2);
                index.put(c, t2); 
                t2++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) { 
                    // Returns a Collection view of the values contained in this map.
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c); // Removes the mapping for the specified key from this map
                t1 = leftMost + 1;
            }
            res = Math.max(res, t2 - t1);
        }
        return res;
        
    }
}