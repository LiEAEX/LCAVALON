class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        int t1 = 0;
        int t2 = 0;
        int res = 0;
        while(t2 < s.length()) {
            if(index.size() <= 2) { // Returns the number of key-value mappings in this map.
                char c = s.charAt(t2);  //不同的数不超过2时，不断更新res, 初始时t1=0, res=t2
                index.put(c, t2); //当key相同时，后面的value会覆盖前面的value
                t2++;
            }
            if(index.size() > 2) {  //不同的数超过2时, 即有3个，移除最前面一个，以leftMost + 1为新的搜索起点
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
